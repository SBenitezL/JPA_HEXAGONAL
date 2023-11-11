package co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarPublicacionCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarPublicacionGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;

public class GestionarPublicacionCUAdapter implements GestionarPublicacionCUIntPort {

    private final GestionarPublicacionGatewayIntPort gatewayPublicacion;
    //formateador de resultados de error

    public GestionarPublicacionCUAdapter(GestionarPublicacionGatewayIntPort gatewayPublicacion){
        this.gatewayPublicacion = gatewayPublicacion;
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {
        if(this.gatewayPublicacion.existePublicacionPorId(publicacion.getIdPublicacion()) ){
            return null;
        }else{
            return this.gatewayPublicacion.crearPublicacion(publicacion);
        }
    }
    
}
