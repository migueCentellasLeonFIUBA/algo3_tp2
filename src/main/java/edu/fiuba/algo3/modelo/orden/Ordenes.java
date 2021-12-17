package edu.fiuba.algo3.modelo.orden;

import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaces;

public interface Ordenes {

    Ordenes emitirOrden(Secuaces ladron);
    boolean arrestarLadron(Secuaces arrestado);
}
