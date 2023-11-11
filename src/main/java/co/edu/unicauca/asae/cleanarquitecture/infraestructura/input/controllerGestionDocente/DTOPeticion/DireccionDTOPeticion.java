package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DireccionDTOPeticion {

    private int idPersona;
    private DocenteDTOPeticion objDocente;
    private String direccionResidencia;
    private String ciudad;
    private String pais;

    public DireccionDTOPeticion(){

    }
    
}
