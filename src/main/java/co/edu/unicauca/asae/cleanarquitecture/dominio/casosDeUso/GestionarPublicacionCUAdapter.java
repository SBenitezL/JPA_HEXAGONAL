package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarPublicacionCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarPublicacionGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;

public class GestionarPublicacionCUAdapter implements GestionarPublicacionCUIntPort {

    private final GestionarPublicacionGatewayIntPort gatewayPublicacion;
    private final GestionarDocenteGatewayIntPort gatewayDocente;
    //formateador de resultados de error

    public GestionarPublicacionCUAdapter(GestionarPublicacionGatewayIntPort gatewayPublicacion,
                                        GestionarDocenteGatewayIntPort gatewayDocente){
        this.gatewayPublicacion = gatewayPublicacion;
        this.gatewayDocente = gatewayDocente;
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        return this.gatewayPublicacion.crearPublicacion(publicacion);
    }

    @Override
    public Publicacion asignarPublicacionDocente(String correo, String titulo) {
        if(this.gatewayDocente.existeDocenteConCorreo(correo)>0 && this.gatewayPublicacion.existePublicacionPorTitulo(titulo)>0){
            Publicacion publicacion = this.gatewayPublicacion.consultarPublicacionPorTitulo(titulo);
            Docente docente = this.gatewayDocente.consultarDocentePorCorreo(correo);
            publicacion.getDocentes().add(docente);
            System.out.println(publicacion.getDocentes().get(0).getIdPersona());
            return this.gatewayPublicacion.crearPublicacion(publicacion);
        }
        return null;
    }

    @Override
    public List<Publicacion> listarPropuestasEager() {
        return this.gatewayPublicacion.consultarPublicacionesEager();
    }
    
}
