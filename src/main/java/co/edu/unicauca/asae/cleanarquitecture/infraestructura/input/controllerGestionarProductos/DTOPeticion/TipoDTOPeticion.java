package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarProductos.DTOPeticion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoDTOPeticion {
    private int idTipo;
    private String nombre;
}
