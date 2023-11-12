package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers;

import org.mapstruct.Mapper;
import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta.DocenteDTORespuesta;

@Mapper (componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);
    List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes);
}
