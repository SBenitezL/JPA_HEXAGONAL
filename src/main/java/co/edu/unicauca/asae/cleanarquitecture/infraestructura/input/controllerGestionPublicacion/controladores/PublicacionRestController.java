package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarPublicacionCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTOPeticion.PublicacionDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.DTORespuesta.PublicacionDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers.PublicacionMapperInfraestructuraDominio;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.mappers.PublicacionMapperPeticionAObjInt;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apiPublicacion")
@RequiredArgsConstructor
public class PublicacionRestController {

    private final GestionarPublicacionCUIntPort gestionarPublicacionCU;
    private final PublicacionMapperInfraestructuraDominio mapperPublicacion;
    private final PublicacionMapperPeticionAObjInt mapperPeticionAPublicacion;

    @PostMapping("/publicaciones")
    public ResponseEntity<PublicacionDTORespuesta> crear(@RequestBody PublicacionDTOPeticion publicacionPeticion){
        Publicacion publicacionCrear = this.mapperPeticionAPublicacion.mappearPeticionAPublicacionCrear(publicacionPeticion);
        Publicacion publicacionCreada = this.gestionarPublicacionCU.crearPublicacion(publicacionCrear);
        ResponseEntity<PublicacionDTORespuesta> publicacionRespuesta = new ResponseEntity<PublicacionDTORespuesta>(
            mapperPublicacion.mappearDePublicacionARespuesta(publicacionCreada),
            HttpStatus.CREATED
        );
        return publicacionRespuesta;
    }

    @PatchMapping("/publicaciones")
    public ResponseEntity<PublicacionDTORespuesta> asignar(@RequestParam String correo,@RequestParam String titulo){
        System.out.println(correo);
        System.out.println(titulo);
        Publicacion publicacionConsultada = this.gestionarPublicacionCU.asignarPublicacionDocente(correo, titulo);
        ResponseEntity<PublicacionDTORespuesta> publicacionRespuesta = new ResponseEntity<PublicacionDTORespuesta>(
            mapperPublicacion.mappearDePublicacionARespuesta(publicacionConsultada),
            HttpStatus.CREATED
        );
        return publicacionRespuesta;
    }

    @GetMapping("/publicaciones")
    public List<PublicacionDTORespuesta> listar(){
        /*ResponseEntity<List<PublicacionDTORespuesta>> objRespuesta = new ResponseEntity<List<PublicacionDTORespuesta>>(
            mapperPublicacion.mappearDePublicacionesARespuesta(this.gestionarPublicacionCU.listarPropuestasEager()),
            HttpStatus.OK);
        return objRespuesta;*/
        List<Publicacion> p = this.gestionarPublicacionCU.listarPropuestasEager();

        return this.mapperPeticionAPublicacion.mapperPublicacionesARespuesta(p);
    }
}
