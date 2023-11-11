package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.cleanarquitecture.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.cleanarquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers.DocenteMapperInfraestructuraDominio;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionDocente.mappers.DocenteMapperPeticionAObjInt;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apiDocente")
@RequiredArgsConstructor
public class DocenteRestController {
    private final GestionarDocenteCUIntPort gestionarDocenteCU;
    private final DocenteMapperInfraestructuraDominio mapperDocente;
    private final DocenteMapperPeticionAObjInt mapperPeticionDocente;

    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> create(@RequestBody DocenteDTOPeticion docentePeticion){
        Docente docenteCrear = mapperPeticionDocente.mappearPeticionADocente(docentePeticion);
        //Docente docenteCrear = this.mapperDocente.mappearDePeticionADocente(docentePeticion);
        Docente docenteCreado = this.gestionarDocenteCU.crearDocente(docenteCrear);
        ResponseEntity<DocenteDTORespuesta> docenteRespuesta = new ResponseEntity<DocenteDTORespuesta>(
            mapperDocente.mappearDeDocenteARespuesta(docenteCreado),
            HttpStatus.CREATED);
        return docenteRespuesta;
    }

    @GetMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> findByCorreo(@RequestParam String correo){
        Docente docenteConCorreo = this.gestionarDocenteCU.consultarDocentePorCorreo(correo);
        ResponseEntity<DocenteDTORespuesta> docenteRespuesta = new ResponseEntity<DocenteDTORespuesta>(
            mapperDocente.mappearDeDocenteARespuesta(docenteConCorreo),
            HttpStatus.OK
        );
        return docenteRespuesta;
    }


}
