package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Docentes")
@PrimaryKeyJoinColumn(name = "idPersona")
@Getter
@Setter
@AllArgsConstructor
public class Docente extends Persona{
    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "vinculacion", nullable = false)
    private String vinculacion;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Docentes_Publicaciones",
        joinColumns = @JoinColumn(name = "idPersona"),
        inverseJoinColumns = @JoinColumn(name = "idPublicacion"))
    private List<Publicacion> publicaciones;

    
    @OneToOne(mappedBy = "objDocente",fetch=FetchType.EAGER,cascade = { CascadeType.ALL })
    private Direccion objDireccion;

    public Docente(){
        this.publicaciones = new ArrayList<>();
    }

    public Docente(int Idpersona,String tipoIdentificacion,
                String numeroIdentificacion,String nombres,
                String apellidos,String correo,String vinculacion,String departamento){
        super(Idpersona,tipoIdentificacion,numeroIdentificacion,nombres,apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        this.publicaciones = new ArrayList<Publicacion>();
    }

    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }
}
