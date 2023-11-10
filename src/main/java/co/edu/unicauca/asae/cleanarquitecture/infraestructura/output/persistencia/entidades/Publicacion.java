package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "Publicaciones")
@Data
@AllArgsConstructor
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPublicacion")
    private int idPublicacion;

    @ManyToOne
    @JoinColumn(name = "idTipo", nullable = false)
    private Tipo objTipo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "area", nullable = false)
    private String area;

    public Publicacion(){

    }

    public Publicacion(String titulo,String area){
        this.titulo = titulo;
        this.area = area;
    }
}
