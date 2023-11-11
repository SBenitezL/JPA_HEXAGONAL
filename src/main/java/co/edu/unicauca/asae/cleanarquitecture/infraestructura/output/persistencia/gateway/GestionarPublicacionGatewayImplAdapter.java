package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.gateway;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarPublicacionGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios.PublicacionRepository;

@Service
public class GestionarPublicacionGatewayImplAdapter implements GestionarPublicacionGatewayIntPort{

    private final PublicacionRepository repositorioPublicacion;
    private final ModelMapper mapperPublicacion;

    public GestionarPublicacionGatewayImplAdapter(PublicacionRepository repositorioPublicacion,
                                            ModelMapper mapperPublicacion){
        this.repositorioPublicacion = repositorioPublicacion;
        this.mapperPublicacion = mapperPublicacion;
    }

    @Override
    public boolean existePublicacionPorId(Integer idPublicacion) {
        return this.repositorioPublicacion.findById(idPublicacion).isPresent();
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        PublicacionEntity publicacionEntity = this.mapperPublicacion.map(publicacion, PublicacionEntity.class);
        PublicacionEntity publicacionAlmacenada = this.repositorioPublicacion.save(publicacionEntity);
        Publicacion publicacionRespuesta = this.mapperPublicacion.map(publicacionAlmacenada, Publicacion.class);
        return publicacionRespuesta;
    }

    @Override
    public Publicacion consultarPublicacionPorTitulo(String titulo) {
        PublicacionEntity publicacionConsultada = this.repositorioPublicacion.findByTitulo(titulo);
        Publicacion publicacionRespuesta = this.mapperPublicacion.map(publicacionConsultada, Publicacion.class);
        return publicacionRespuesta;
    }  
}
