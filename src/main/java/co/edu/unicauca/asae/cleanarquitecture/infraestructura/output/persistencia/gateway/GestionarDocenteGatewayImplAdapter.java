package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepositoryInt repositorioDocente;
    private final ModelMapper mapperDocente;

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt repositorioDocente,
                                            ModelMapper mapperDocente){
        this.repositorioDocente = repositorioDocente;
        this.mapperDocente = mapperDocente;
    }

    @Override
    public boolean existeDocentePorId(Integer idDocente) {
        return this.repositorioDocente.findById(idDocente).isPresent();
    }

    @Override
    public Docente crearDocente(Docente docente) {
        DocenteEntity docenteEntity = this.mapperDocente.map(docente,DocenteEntity.class);
        DocenteEntity docenteAlmacenado = this.repositorioDocente.save(docenteEntity);
        Docente docenteRespuesta = this.mapperDocente.map(docenteAlmacenado, Docente.class);
        return docenteRespuesta;
    }

    @Override
    public List<Docente> listarDocenteConPublicacion() {
        Iterable<DocenteEntity> listaDocente = this.repositorioDocente.findAll();
        List<Docente> listaObtenida = this.mapperDocente.map(listaDocente, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public Docente consultarDocentePorCorreo(String correo) {
        DocenteEntity docenteConsultado = this.repositorioDocente.findByCorreo(correo);
        Docente docenteRespuesta = this.mapperDocente.map(docenteConsultado, Docente.class);
        return docenteRespuesta;
    }
    
    
}
