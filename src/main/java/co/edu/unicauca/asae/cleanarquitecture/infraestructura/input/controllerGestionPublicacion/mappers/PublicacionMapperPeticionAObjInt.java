package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion.PublicacionDTOPeticion;

public interface PublicacionMapperPeticionAObjInt {
    Publicacion mappearPeticionAPublicacionCrear(PublicacionDTOPeticion publicacionPeticion);
}
