package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {
    public Docente crearDocente(Docente docente);
    List<Docente> listarDocenteConPublicaciones();
    public Docente consultarDocentePorCorreo(String correo);
}
