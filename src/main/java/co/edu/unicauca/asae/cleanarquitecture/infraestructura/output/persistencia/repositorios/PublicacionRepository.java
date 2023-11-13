package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.PublicacionEntity;

public interface PublicacionRepository  extends CrudRepository<PublicacionEntity,Integer>{

    @Query("SELECT COUNT(p) FROM Publicaciones p WHERE p.titulo = :titulo")
    int existePublicacionPorTitulo(@Param("titulo") String titulo);

    PublicacionEntity findByTitulo(String titulo);

    List<PublicacionEntity> findByTituloIgnoreCaseContainingOrderByIdPublicacion(String patron);
}
