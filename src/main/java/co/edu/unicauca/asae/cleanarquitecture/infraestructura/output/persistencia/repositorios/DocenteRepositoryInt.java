package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity,Integer> {
    /*@Query("SELECT count(*) FROM DocenteEntity d  WHERE d.correo=?1")
    Integer existeDocentePorCorreo(String correo);*/
    
    DocenteEntity findByCorreo(String correo);
}
