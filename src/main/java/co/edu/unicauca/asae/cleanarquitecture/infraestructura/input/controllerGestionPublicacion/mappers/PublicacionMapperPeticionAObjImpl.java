package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Direccion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Tipo;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta.DireccionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers.DocenteMapperPeticionAObjInt;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion.PublicacionDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta.PublicacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta.TipoDTORespuesta;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacionMapperPeticionAObjImpl implements PublicacionMapperPeticionAObjInt{

    @Override
    public Publicacion mappearPeticionAPublicacionCrear(PublicacionDTOPeticion publicacionPeticion) {
        Publicacion publicacionMapeada = new Publicacion();
        Tipo tipo = new Tipo();
        tipo.setIdTipo(publicacionPeticion.getObjTipo().getIdTipo());
        tipo.setNombre(publicacionPeticion.getObjTipo().getNombre());
        publicacionMapeada.setIdPublicacion(publicacionPeticion.getIdPublicacion());
        publicacionMapeada.setTitulo(publicacionPeticion.getTitulo());
        publicacionMapeada.setArea(publicacionPeticion.getArea());
        publicacionMapeada.setObjTipo(tipo);
        return publicacionMapeada;
    }

    @Override
    public List<PublicacionDTORespuesta> mapperPublicacionesARespuesta(List<Publicacion> publicaciones) {
        List<PublicacionDTORespuesta> publicacionesRespuesta = new ArrayList<>();
        for(int i = 0 ; i<publicaciones.size() ; i++){
            Publicacion pActual = publicaciones.get(i);
            PublicacionDTORespuesta publicacionMapeada = new PublicacionDTORespuesta();
            publicacionMapeada.setIdPublicacion(pActual.getIdPublicacion());
            publicacionMapeada.setTitulo(pActual.getTitulo());
            publicacionMapeada.setArea(pActual.getArea());
            TipoDTORespuesta tipoMapeado = new TipoDTORespuesta();
            tipoMapeado.setIdTipo(pActual.getObjTipo().getIdTipo());
            tipoMapeado.setNombre(pActual.getObjTipo().getNombre());
            publicacionMapeada.setObjTipo(tipoMapeado);
            List<DocenteDTORespuesta> docentesMapeados = mapearDocentes(pActual.getDocentes());
            publicacionMapeada.setDocentes(docentesMapeados);
            publicacionesRespuesta.add(publicacionMapeada);
        }
        return publicacionesRespuesta;
    }

    private List<DocenteDTORespuesta> mapearDocentes(List<Docente> docentesPeticion){
        List<DocenteDTORespuesta> docentes = new ArrayList<>();
        for(int i = 0 ; i<docentesPeticion.size() ; i++){
            Docente docentePeticion = docentesPeticion.get(i);
            DocenteDTORespuesta docenteMapeado = new DocenteDTORespuesta();
            docenteMapeado.setIdPersona(docentePeticion.getIdPersona());
            docenteMapeado.setTipoIdentificacion(docentePeticion.getTipoIdentificacion());
            docenteMapeado.setNumeroIdentificacion(docentePeticion.getNumeroIdentificacion());
            docenteMapeado.setVinculacion(docentePeticion.getVinculacion());
            docenteMapeado.setDepartamento(docentePeticion.getDepartamento());
            docenteMapeado.setNombres(docentePeticion.getNombres());
            docenteMapeado.setApellidos(docentePeticion.getApellidos());
            docenteMapeado.setCorreo(docentePeticion.getCorreo());
            DireccionDTORespuesta direccionMapeada = new DireccionDTORespuesta();
            direccionMapeada.setIdPersona(docentePeticion.getIdPersona());
            direccionMapeada.setDireccionResidencia(docentePeticion.getObjDireccion().getDireccionResidencia());
            direccionMapeada.setCiudad(docentePeticion.getObjDireccion().getCiudad());
            direccionMapeada.setPais(docentePeticion.getObjDireccion().getPais());
            docenteMapeado.setObjDireccion(direccionMapeada);
            docentes.add(docenteMapeado);
        }
        return docentes;
    }
    
}
