package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublicacionDTORespuesta {
    private int idPublicacion;
    private TipoDTORespuesta objTipo;
    private String titulo;
    private String area;
    
    public PublicacionDTORespuesta(){
        
    }
}
