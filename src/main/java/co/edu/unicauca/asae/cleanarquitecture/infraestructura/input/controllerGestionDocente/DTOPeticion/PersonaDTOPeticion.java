package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTOPeticion {
    
    private int idPersona;
    @NotEmpty(message ="{persona.tidentificacion.empty}")
    private String tipoIdentificacion;
    @NotEmpty(message ="{persona.identificacion.empty}")
    private String numeroIdentificacion;
    @NotEmpty(message ="{persona.nombres.empty}")
    private String nombres;
    @NotEmpty(message ="{persona.apellidos.empty}")
    private String apellidos;

    public PersonaDTOPeticion(){
        
    }
}
