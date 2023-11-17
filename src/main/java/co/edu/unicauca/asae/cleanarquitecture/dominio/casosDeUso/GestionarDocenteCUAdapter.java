package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;


import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{

    private final GestionarDocenteGatewayIntPort gatewayDocente;
    //formateador de resultados para errores

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort gatewayDocente){
        this.gatewayDocente = gatewayDocente;
    }
    
    @Override
    public Docente crearDocente(Docente docente) {
        if(this.gatewayDocente.existeDocenteConCorreo(docente.getCorreo()) == 0){
            return this.gatewayDocente.crearDocente(docente);
        }else{
            EntidadYaExisteException objException = new EntidadYaExisteException(
                "Docente con correo " + docente.getCorreo() +" existe en la BD");
                throw objException;
        }
    }
    

    @Override
    public Docente consultarDocentePorCorreo(String correo) {
        if(this.gatewayDocente.existeDocenteConCorreo(correo) > 0) 
            return this.gatewayDocente.consultarDocentePorCorreo(correo);
        else{
            EntidadNoExisteException objException = new EntidadNoExisteException("El docente con correo " + correo + " no esta registrado.");
            throw objException;
        }
    }
    
}
