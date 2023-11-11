package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Tipo;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers.DocenteMapperPeticionAObjInt;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion.PublicacionDTOPeticion;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacionMapperPeticionAObjImpl implements PublicacionMapperPeticionAObjInt{

    private final DocenteMapperPeticionAObjInt mapperDocente;

    @Override
    public Publicacion mappearPeticionAPublicacionCrear(PublicacionDTOPeticion publicacionPeticion) {
        Publicacion publicacionMapeada = new Publicacion();
        Tipo tipo = new Tipo();
        tipo.setIdTipo(publicacionPeticion.getObjTipo().getIdTipo());
        tipo.setNombre(publicacionPeticion.getObjTipo().getNombre());
        publicacionMapeada.setIdPublicacion(publicacionPeticion.getIdPublicacion());
        publicacionMapeada.setTitulo(publicacionPeticion.getTitulo());
        publicacionMapeada.setArea(publicacionPeticion.getArea());
        //publicacionMapeada.setDocentes(mapearDocentes(publicacionPeticion.getDocentes()));
        publicacionMapeada.setObjTipo(tipo);
        return publicacionMapeada;
    }

    private List<Docente> mapearDocentes(List<DocenteDTOPeticion> docentesPeticion){
        List<Docente> docentes = new ArrayList<>();
        for(int i = 0 ; i<docentesPeticion.size() ; i++){
            DocenteDTOPeticion docentePeticion = docentesPeticion.get(i);
            Docente docenteMapeado = this.mapperDocente.mappearPeticionADocente(docentePeticion);
            docentes.add(docenteMapeado);
        }
        return docentes;
    }
    
}
