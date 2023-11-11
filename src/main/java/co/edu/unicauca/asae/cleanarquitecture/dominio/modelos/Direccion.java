package co.edu.unicauca.asae.cleanarquitecture.dominio.modelos;

import javax.print.DocFlavor.STRING;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Direccion {

    private int idPersona;
    private Docente objDocente;
    private String direccionResidencia;
    private String ciudad;
    private String pais;

    public Direccion(){

    }

    public Direccion(int idPersona,String direccionResidencia,String ciudad,String pais){
        this.idPersona = idPersona;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
}
