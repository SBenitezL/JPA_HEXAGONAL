package co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.GestionarPublicacionGatewayIntPort;
import co.edu.unicauca.asae.cleanarquitecture.aplicacion.output.ProductoFormateadorResultadosIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.cleanarquitecture.dominio.casosDeUso.GestionarPublicacionCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
        GestionarDocenteGatewayIntPort gatewayDocente){
        GestionarDocenteCUAdapter gestionarDocenteCU = new GestionarDocenteCUAdapter(gatewayDocente);
        return gestionarDocenteCU;
    }

    @Bean
    public GestionarPublicacionCUAdapter crearGestionarPublicacionCUInt(
        GestionarPublicacionGatewayIntPort gatewayPublicacion,
        GestionarDocenteGatewayIntPort gatewayDocente){
        GestionarPublicacionCUAdapter gestionarPublicacionCU = new GestionarPublicacionCUAdapter(gatewayPublicacion,gatewayDocente);
        return gestionarPublicacionCU;
    }
}