package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity,Integer> {

    @Query("SELECT COUNT(d) FROM Docentes d WHERE d.correo = :correo")
    int existeDocentePorCorreo(@Param("correo") String correo);
    
    DocenteEntity findByCorreo(String correo);
}
