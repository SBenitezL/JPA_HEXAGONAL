package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion.DocenteDTOPeticion;

public interface DocenteMapperPeticionAObjInt {
    Docente mappearPeticionADocente(DocenteDTOPeticion docentePeticion);
}
