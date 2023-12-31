package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta.PublicacionDTORespuesta;

@Mapper (componentModel = "spring")
public interface PublicacionMapperInfraestructuraDominio {
    PublicacionDTORespuesta mappearDePublicacionARespuesta(Publicacion publicacion);
    List<PublicacionDTORespuesta> mappearDePublicacionesARespuesta(List<Publicacion> publicaciones);
}