package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublicacionDTORespuesta {

    private int idPublicacion;
    private TipoDTORespuesta objTipo;
    private String titulo;
    private String area;
    private List<DocenteDTORespuesta> docentes;

    public PublicacionDTORespuesta(){

    }
}
