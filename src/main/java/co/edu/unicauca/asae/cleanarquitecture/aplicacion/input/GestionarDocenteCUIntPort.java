package co.edu.unicauca.asae.cleanarquitecture.aplicacion.input;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {
    public Docente crearDocente(Docente docente);
    public Docente consultarDocentePorCorreo(String correo);
}
