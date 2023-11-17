package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarPublicacionCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarPublicacionGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

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
        if(this.gatewayPublicacion.existePublicacionPorTitulo(publicacion.getTitulo()) == 0){
            return this.gatewayPublicacion.crearPublicacion(publicacion);
        }
        EntidadYaExisteException objException = new EntidadYaExisteException("La publicación con titulo " + publicacion.getTitulo() + " ya existe");
        throw objException;
    }

    @Override
    public Publicacion asignarPublicacionDocente(String correo, String titulo) {
        if(this.gatewayDocente.existeDocenteConCorreo(correo)>0 ){
            if(this.gatewayPublicacion.existePublicacionPorTitulo(titulo)>0){
                Publicacion publicacion = this.gatewayPublicacion.consultarPublicacionPorTitulo(titulo);
                Docente docente = this.gatewayDocente.consultarDocentePorCorreo(correo);
                publicacion.getDocentes().add(docente);
                System.out.println(publicacion.getDocentes().get(0).getIdPersona());
                return this.gatewayPublicacion.crearPublicacion(publicacion);
            }else{
                EntidadNoExisteException objExcPublicacion = new EntidadNoExisteException("La publicacion con titulo " + titulo + " no esta registrada");
                throw objExcPublicacion;
            }
        }else{
            EntidadNoExisteException objExcDocente = new EntidadNoExisteException("El docente con correo " + correo + " no esta registrado");
            throw objExcDocente;
        }
    }

    @Override
    public List<Publicacion> listarPropuestas() {
        List<Publicacion> publicaciones = this.gatewayPublicacion.consultarPublicaciones();
        if(publicaciones.size() > 0) return publicaciones;
        EntidadNoExisteException objExcDocente = new EntidadNoExisteException("No hay publicaciones registradas.");
            throw objExcDocente;
    }

    @Override
    public Publicacion consultarPublicacionPorTitulo(String titulo) {
        if(this.gatewayPublicacion.existePublicacionPorTitulo(titulo) != 0){
            return this.gatewayPublicacion.consultarPublicacionPorTitulo(titulo);
        }
        EntidadNoExisteException objExcDocente = new EntidadNoExisteException("La publicación con título " + titulo + " no esta registrada");
            throw objExcDocente;
    }

    @Override
    public List<Publicacion> consultarPublicacionPorPatron(String patron) {
        List<Publicacion> publicaciones = this.gatewayPublicacion.consultarPublicacionsPorPatron(patron);
        if(publicaciones.size() > 0) return publicaciones;
        EntidadNoExisteException objExcDocente = new EntidadNoExisteException("No hay publicaciones registradas con el patron "+ patron +".");
            throw objExcDocente;
    }
    
}
