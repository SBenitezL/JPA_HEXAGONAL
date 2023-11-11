package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Direccion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion.DocenteDTOPeticion;

@Service
public class DocenteMapperPeticionAObjImpl implements DocenteMapperPeticionAObjInt{

    @Override
    public Docente mappearPeticionADocente(DocenteDTOPeticion docentePeticion) {
        Direccion direccion = new Direccion(docentePeticion.getIdPersona(),docentePeticion.getObjDireccion().getDireccionResidencia()
        ,docentePeticion.getObjDireccion().getCiudad(),docentePeticion.getObjDireccion().getPais());
        Docente docente = new Docente(docentePeticion.getIdPersona(), docentePeticion.getTipoIdentificacion(), docentePeticion.getNumeroIdentificacion(), docentePeticion.getNombres(),
        docentePeticion.getApellidos(), docentePeticion.getCorreo(), docentePeticion.getVinculacion(),
        docentePeticion.getDepartamento(),direccion);
        direccion.setObjDocente(docente);
        return docente;
    }
    
}
