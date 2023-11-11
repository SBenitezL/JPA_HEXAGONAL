package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DocenteDTORespuesta extends PersonaDTORespuesta {

    private String correo;
    private String vinculacion;
    private String departamento;
    //private List<PublicacionDTORespuesta> publicaciones;
    private DireccionDTORespuesta objDireccion;

    public DocenteDTORespuesta(int idPersona,String tipoIdentificacion,String numeroIdentificacion,
                String nombres,String apellidos,String correo,String vinculacion,String departamento,
                DireccionDTORespuesta objDireccion){
        super(idPersona,tipoIdentificacion,numeroIdentificacion,nombres,apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        this.objDireccion = objDireccion;
        //this.publicaciones = new ArrayList<>();
    }

}
