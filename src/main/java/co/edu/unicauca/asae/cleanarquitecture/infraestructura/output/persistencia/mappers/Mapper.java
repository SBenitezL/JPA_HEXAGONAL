package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.MapAccessor;

import aj.org.objectweb.asm.Type;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Direccion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Tipo;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.TipoEntity;

import org.modelmapper.TypeMap;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper crearMapper() {
        ModelMapper mapper = new ModelMapper();
        /*Crear docente y consultarlo por correo */
        /*TypeMap<DireccionEntity,Direccion> mapaDireccion = mapper.emptyTypeMap(DireccionEntity.class, Direccion.class);
        mapaDireccion.addMappings(m -> m.skip(Direccion::setObjDocente)).implicitMappings();*/

        /*Crear publicacion*/
        /*TypeMap<TipoEntity,Tipo> mapaTipo = mapper.emptyTypeMap(TipoEntity.class, Tipo.class);
        mapaTipo.addMappings(m -> m.skip(Tipo::setPublicaciones)).implicitMappings();*/
        
        /*Consultar publicaciones */
        /*TypeMap<TipoEntity,Tipo> mapaTipo = mapper.emptyTypeMap(TipoEntity.class, Tipo.class);
        mapaTipo.addMappings(m -> m.skip(Tipo::setPublicaciones)).implicitMappings();
        TypeMap<DireccionEntity,Direccion> mapaDireccion = mapper.emptyTypeMap(DireccionEntity.class, Direccion.class);
        mapaDireccion.addMappings(m -> m.skip(Direccion::setObjDocente)).implicitMappings();*/


        /*Asigna publicacion a docente */
        /*TypeMap<DireccionEntity,Direccion> mapaDireccion = mapper.emptyTypeMap(DireccionEntity.class, Direccion.class);
        TypeMap<TipoEntity,Tipo> mapaTipo = mapper.emptyTypeMap(TipoEntity.class, Tipo.class);
        mapaDireccion.addMappings(m -> m.skip(Direccion::setObjDocente)).implicitMappings();
        mapaTipo.addMappings(m -> m.skip(Tipo::setPublicaciones)).implicitMappings();*/

        /*Para Eager */
        // TypeMap<TipoEntity,Tipo> mapaTipo = mapper.emptyTypeMap(TipoEntity.class, Tipo.class);
        // TypeMap<DireccionEntity,Direccion> mapaDireccion = mapper.emptyTypeMap(DireccionEntity.class, Direccion.class);
        // mapaDireccion.addMappings(m -> m.skip(Direccion::setObjDocente)).implicitMappings();
        // mapaTipo.addMappings(m -> m.skip(Tipo::setPublicaciones)).implicitMappings();
        
        /*Para Lazy */
        TypeMap<PublicacionEntity, Publicacion> mapaPublicacion = mapper.emptyTypeMap(PublicacionEntity.class, Publicacion.class);
        TypeMap<DocenteEntity,Docente> mapaDocente = mapper.emptyTypeMap(DocenteEntity.class, Docente.class);
        mapaDocente.addMappings(m -> m.skip(Docente::setObjDireccion)).implicitMappings();
        mapaPublicacion.addMappings(m -> m.skip(Publicacion::setObjTipo)).implicitMappings();
        //
        /*Para el patron de busqueda solicitado */


        return mapper;
    }
}