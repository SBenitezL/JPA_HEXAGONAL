package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import java.util.List;

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
        if(this.gatewayDocente.existeDocentePorId(docente.getIdPersona())){
            return null;
        }
        return this.gatewayDocente.crearDocente(docente);
    }

    @Override
    public List<Docente> listarDocenteConPublicaciones() {
        return this.gatewayDocente.listarDocenteConPublicacion();
    }

    @Override
    public Docente consultarDocentePorCorreo(String correo) {
        return this.gatewayDocente.consultarDocentePorCorreo(correo);
    }
    
}
