package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

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
public class DocenteEntity extends PersonaEntity{
    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "vinculacion", nullable = false)
    private String vinculacion;

    @Column(name = "departamento", nullable = false)
    private String departamento;
    
    @OneToOne(mappedBy = "objDocente",fetch=FetchType.EAGER,cascade = { CascadeType.ALL })
    private DireccionEntity objDireccion;

    public DocenteEntity(){
        
    }

    public DocenteEntity(int Idpersona,String tipoIdentificacion,
                String numeroIdentificacion,String nombres,
                String apellidos,String correo,String vinculacion,String departamento){
        super(Idpersona,tipoIdentificacion,numeroIdentificacion,nombres,apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
    }
}
