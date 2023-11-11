package co.edu.unicauca.asae.cleanarquitecture.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tipo {
    private int idTipo;
    private String nombre;
    List<Publicacion> publicaciones;

    public Tipo(){
        this.publicaciones = new ArrayList<>();
    }
 
}
