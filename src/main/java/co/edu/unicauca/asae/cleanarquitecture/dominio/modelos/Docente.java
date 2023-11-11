package co.edu.unicauca.asae.cleanarquitecture.dominio.modelos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Docente extends Persona {

    private String correo;
    private String vinculacion;
    private String departamento;
    private Direccion objDireccion;

    public Docente(){

    }
    
    public Docente(int idPersona,String tipoIdentificacion,String numeroIdentificacion,
                String nombres,String apellidos,String correo,String vinculacion,String departamento,
                Direccion objDireccion){
        super(idPersona,tipoIdentificacion,numeroIdentificacion,nombres,apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        this.objDireccion = objDireccion;
    }

}
