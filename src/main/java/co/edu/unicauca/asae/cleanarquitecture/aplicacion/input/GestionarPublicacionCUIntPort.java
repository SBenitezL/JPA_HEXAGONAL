package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;

public interface GestionarPublicacionCUIntPort {
    public Publicacion crearPublicacion(Publicacion publicacion);
    public Publicacion asignarPublicacionDocente(String correo,String titulo);
    public List<Publicacion> listarPropuestasEager();
}
