package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DireccionDTORespuesta {

    private int idPersona;
    //private DocenteDTORespuesta objDocente;
    private String direccionResidencia;
    private String ciudad;
    private String pais;

    public DireccionDTORespuesta(){

    }
    
}
