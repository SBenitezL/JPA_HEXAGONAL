package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;

public interface GestionarPublicacionGatewayIntPort {
    public boolean existePublicacionPorId(Integer idPublicacion);
    public Publicacion crearPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacionPorTitulo(String titulo);
}
