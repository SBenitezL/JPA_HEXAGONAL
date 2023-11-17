package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionPublicacion.controladores;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

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
    public ResponseEntity<PublicacionDTORespuesta> crear(@Valid @RequestBody PublicacionDTOPeticion publicacionPeticion){
        Publicacion publicacionCrear = this.mapperPeticionAPublicacion.mappearPeticionAPublicacionCrear(publicacionPeticion);
        Publicacion publicacionCreada = this.gestionarPublicacionCU.crearPublicacion(publicacionCrear);
        ResponseEntity<PublicacionDTORespuesta> publicacionRespuesta = new ResponseEntity<PublicacionDTORespuesta>(
            mapperPublicacion.mappearDePublicacionARespuesta(publicacionCreada),
            HttpStatus.CREATED
        );
        return publicacionRespuesta;
    }

    @GetMapping("/publicaciones")
    public ResponseEntity<PublicacionDTORespuesta> consultarPorTitulo(@NotEmpty(message = "{publicacion.titulo.empty}") @RequestParam String titulo){
        Publicacion publicacionConsultada = this.gestionarPublicacionCU.consultarPublicacionPorTitulo(titulo);
        ResponseEntity<PublicacionDTORespuesta> publicacionRespuesta = new ResponseEntity<PublicacionDTORespuesta>(
            mapperPublicacion.mappearDePublicacionARespuesta(publicacionConsultada),
            HttpStatus.OK
        );
        return publicacionRespuesta;
    }

    @PatchMapping("/publicaciones")
    public ResponseEntity<PublicacionDTORespuesta> asignar(@RequestParam String correo,@RequestParam String titulo){
        Publicacion publicacionConsultada = this.gestionarPublicacionCU.asignarPublicacionDocente(correo, titulo);
        ResponseEntity<PublicacionDTORespuesta> publicacionRespuesta = new ResponseEntity<PublicacionDTORespuesta>(
            mapperPublicacion.mappearDePublicacionARespuesta(publicacionConsultada),
            HttpStatus.CREATED
        );
        return publicacionRespuesta;
    }

    @GetMapping("/publicacionesEager")
    public ResponseEntity<List<PublicacionDTORespuesta>> listarEager(){
        List<Publicacion> publicaciones = this.gestionarPublicacionCU.listarPropuestas();
        ResponseEntity<List<PublicacionDTORespuesta>> objRespuesta = new ResponseEntity<List<PublicacionDTORespuesta>>(
            mapperPublicacion.mappearDePublicacionesARespuesta(publicaciones),
            HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/publicacionesLazy")
    public ResponseEntity<List<PublicacionDTORespuesta>> listarLazy(){
        List<Publicacion> publicaciones = this.gestionarPublicacionCU.listarPropuestas();
        ResponseEntity<List<PublicacionDTORespuesta>> objRespuesta = new ResponseEntity<List<PublicacionDTORespuesta>>(
            mapperPublicacion.mappearDePublicacionesARespuesta(publicaciones),
            HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/publicacionesPatron")
    public ResponseEntity<List<PublicacionDTORespuesta>> listarPatron(@RequestParam String patron){
        List<Publicacion> publicaciones = this.gestionarPublicacionCU.consultarPublicacionPorPatron(patron);
        ResponseEntity<List<PublicacionDTORespuesta>> objRespuesta = new ResponseEntity<List<PublicacionDTORespuesta>>(
            mapperPublicacion.mappearDePublicacionesARespuesta(publicaciones),
            HttpStatus.OK);
        return objRespuesta;
    }
}
