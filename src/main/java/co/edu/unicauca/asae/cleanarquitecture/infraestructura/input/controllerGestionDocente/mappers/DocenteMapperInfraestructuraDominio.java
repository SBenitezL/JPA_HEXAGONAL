package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers;

import org.mapstruct.Mapper;
import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta.DocenteDTORespuesta;

@Mapper (componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mappearDePeticionADocente(DocenteDTOPeticion Docente);
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);
    List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes);
}
