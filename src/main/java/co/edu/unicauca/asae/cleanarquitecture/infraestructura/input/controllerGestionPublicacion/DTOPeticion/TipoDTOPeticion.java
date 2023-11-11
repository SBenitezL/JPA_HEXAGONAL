package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDTOPeticion {
    private int idTipo;
    private String nombre;
    List<PublicacionDTOPeticion> publicaciones;

    public TipoDTOPeticion(){
        this.publicaciones = new ArrayList<>();
    }
}
