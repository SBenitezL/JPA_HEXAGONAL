package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionDocentesRuntimeException extends RuntimeException{
    protected CodigoError codigoError;
    public abstract String formatException();
}