package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;


import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;

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
        }
        return null;
    }

    @Override
    public Docente consultarDocentePorCorreo(String correo) {
        return this.gatewayDocente.consultarDocentePorCorreo(correo);
    }
    
}
