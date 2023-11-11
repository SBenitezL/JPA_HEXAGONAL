package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Direcciones")
@Getter
@Setter
public class DireccionEntity {

	@Id
	@Column(name = "idPersona")
	private int idPersona;
    
	@OneToOne
	@MapsId
	@JoinColumn(name = "idPersona")
	private DocenteEntity objDocente;

    @Column(nullable = false)
	private String direccionResidencia;
    @Column(nullable = false)	
    private String ciudad;	
    @Column(nullable = false)
	private String pais;	
    
	public DireccionEntity(){

	}

    public DireccionEntity(String direccionResidencia, String ciudad, String pais) {
		this.direccionResidencia = direccionResidencia;
		this.ciudad = ciudad;
		this.pais = pais;
	}
}

