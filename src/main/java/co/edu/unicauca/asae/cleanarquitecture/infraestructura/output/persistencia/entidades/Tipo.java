package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name="Tipos")
@Getter
@Setter

public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipo")
    private Integer idTipo;

    @Column(name = "nombre",nullable = false, length = 45)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "objTipo")
    List<Publicacion> publicaciones;

    public Tipo(){
        
    }

    public Tipo(String nombre ){
        this.nombre = nombre;
        this.publicaciones = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }

}
