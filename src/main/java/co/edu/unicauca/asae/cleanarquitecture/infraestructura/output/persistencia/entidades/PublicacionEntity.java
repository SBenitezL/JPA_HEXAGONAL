package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "Publicaciones")
@Data
@AllArgsConstructor
public class PublicacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPublicacion")
    private int idPublicacion;

    @ManyToOne
    @JoinColumn(name = "idTipo", nullable = false)
    private TipoEntity objTipo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "area", nullable = false)
    private String area;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Docentes_Publicaciones",
        joinColumns = @JoinColumn(name = "idPublicacion"),
        inverseJoinColumns = @JoinColumn(name = "idPersona"))
    private List<DocenteEntity> docentes;

    public PublicacionEntity(){
        this.docentes = new ArrayList<>();
    }

    public PublicacionEntity(String titulo,String area){
        this.titulo = titulo;
        this.area = area;
    }
}
