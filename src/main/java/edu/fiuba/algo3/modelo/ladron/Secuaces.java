package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Reloj;

public interface Secuaces {

    boolean arrestar();
    //boolean esLadron(String nombre);
    void atacar(Jugador jugador);

    void setPistola();
}
