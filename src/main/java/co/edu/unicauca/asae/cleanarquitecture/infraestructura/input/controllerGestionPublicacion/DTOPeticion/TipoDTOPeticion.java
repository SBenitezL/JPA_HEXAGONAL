package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDTOPeticion {
    private int idTipo;
    private String nombre;

    public TipoDTOPeticion(){

    }
}
