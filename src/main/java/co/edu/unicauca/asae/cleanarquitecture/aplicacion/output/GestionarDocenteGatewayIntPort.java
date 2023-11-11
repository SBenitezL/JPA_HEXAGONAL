package co.edu.unicauca.asae.cleanarquitecture.aplicacion.output;

import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import java.util.List;

public interface GestionarDocenteGatewayIntPort {
    public boolean existeDocentePorId(Integer idDocente);
    public Docente crearDocente(Docente docente);
    public List<Docente> listarDocenteConPublicacion();
    public Docente consultarDocentePorCorreo(String correo);
}
