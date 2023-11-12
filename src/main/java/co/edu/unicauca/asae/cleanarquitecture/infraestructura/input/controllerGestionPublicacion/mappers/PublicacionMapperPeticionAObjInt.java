package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers;

import java.util.List;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion.PublicacionDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta.PublicacionDTORespuesta;

public interface PublicacionMapperPeticionAObjInt {
    Publicacion mappearPeticionAPublicacionCrear(PublicacionDTOPeticion publicacionPeticion);
    List<PublicacionDTORespuesta> mapperPublicacionesARespuesta(List<Publicacion> publicaciones);
}
