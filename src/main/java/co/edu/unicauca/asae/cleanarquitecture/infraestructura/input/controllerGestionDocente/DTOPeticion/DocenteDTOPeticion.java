package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DocenteDTOPeticion extends PersonaDTOPeticion {

    @NotEmpty(message = "{docente.correo.empty}")
    @Email(message="{docente.correo.email}")
    private String correo;
    private String vinculacion;
    @NotEmpty(message = "{docente.departamento.empty}")
    private String departamento;
    @NotNull(message = "{docente.direccion.empty}")
    private DireccionDTOPeticion objDireccion;

    public DocenteDTOPeticion(int idPersona,String tipoIdentificacion,String numeroIdentificacion,
                String nombres,String apellidos,String correo,String vinculacion,String departamento,
                DireccionDTOPeticion objDireccion){
        super(idPersona,tipoIdentificacion,numeroIdentificacion,nombres,apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        this.objDireccion = objDireccion;
    }

}
