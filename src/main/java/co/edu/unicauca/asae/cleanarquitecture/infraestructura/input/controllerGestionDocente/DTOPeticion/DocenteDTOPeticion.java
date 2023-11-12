package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DocenteDTOPeticion extends PersonaDTOPeticion {

    private String correo;
    private String vinculacion;
    private String departamento;
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
