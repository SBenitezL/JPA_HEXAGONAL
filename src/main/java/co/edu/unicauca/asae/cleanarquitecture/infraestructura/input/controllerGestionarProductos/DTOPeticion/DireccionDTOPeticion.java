package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarProductos.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DireccionDTOPeticion {
    private int idPersona;
    @NotNull(message="{direccion.direccionResidencia.notNull}")
    @Size (min = 5, max = 45, message = "{direccion.direccionResidencia.size}")
    private String direccionResidencia;
    @NotNull(message = "{direccion.ciudad.notNull}")
    @Size(min = 5, max = 45, message = "{direccion.ciudad.size}")
    private String ciudad;
    @NotNull(message="{direccion.pais.notNull}")
    @Size(min = 5, max = 45, message = "{direccion.pais.size}")
    private String pais;
}
