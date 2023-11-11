package co.edu.unicauca.asae.cleanarquitecture.dominio.modelos;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Publicacion {

    private int idPublicacion;
    private Tipo objTipo;
    private String titulo;
    private String area;
    private List<Docente> docentes;

    public Publicacion(){
        this.docentes = new ArrayList<>();
    }
}
