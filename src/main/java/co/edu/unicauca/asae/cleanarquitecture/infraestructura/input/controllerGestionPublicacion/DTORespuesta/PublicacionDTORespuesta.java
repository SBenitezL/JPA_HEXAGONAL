package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta.DocenteDTORespuesta;
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
        this.docentes = new ArrayList<>();
    }
}
