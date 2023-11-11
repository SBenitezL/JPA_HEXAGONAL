package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublicacionDTOPeticion {
    private int idPublicacion;
    private TipoDTOPeticion objTipo;
    private String titulo;
    private String area;

    public PublicacionDTOPeticion(){

    }
}
