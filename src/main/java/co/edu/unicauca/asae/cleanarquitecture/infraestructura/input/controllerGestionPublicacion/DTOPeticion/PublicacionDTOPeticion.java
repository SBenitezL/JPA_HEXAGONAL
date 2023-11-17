package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublicacionDTOPeticion {
    @Min(value = 1, message = "{publicacion.id.min}")
    private int idPublicacion;
    @NotNull(message = "{publicacion.peticion.empty}")
    private TipoDTOPeticion objTipo;
    @NotEmpty(message="{publicacion.titulo.empty}")
    private String titulo;
    @NotEmpty(message = "{publicacion.area.empty}")
    private String area;

    public PublicacionDTOPeticion(){

    }
}
