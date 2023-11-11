package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDTORespuesta {
    private int idTipo;
    private String nombre;
    List<PublicacionDTORespuesta> publicaciones;

    public TipoDTORespuesta(){
        this.publicaciones = new ArrayList<>();
    }
 
}
