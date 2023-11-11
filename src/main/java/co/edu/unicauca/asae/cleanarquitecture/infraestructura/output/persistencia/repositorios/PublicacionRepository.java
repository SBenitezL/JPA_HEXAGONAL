package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.PublicacionEntity;

public interface PublicacionRepository  extends CrudRepository<PublicacionEntity,Integer>{
   /*@Query("SELECT count(*) FROM PublicacionEntity p  WHERE p.titulo=?1")
    Integer existePublicacionPorTitulo(String titulo);*/

    PublicacionEntity findByTitulo(String titulo);
}
