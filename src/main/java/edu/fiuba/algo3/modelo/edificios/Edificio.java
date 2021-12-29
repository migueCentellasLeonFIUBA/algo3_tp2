package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ILadron;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.rangos.Detective;
import edu.fiuba.algo3.modelo.rangos.Investigador;
import edu.fiuba.algo3.modelo.rangos.Novato;
import edu.fiuba.algo3.modelo.rangos.Sargento;

import java.util.Map;

public abstract class Edificio {
    IPista pista;
    String nombre;
    ILadron ladron;


    public abstract void cambiarPista(Map<String, IPista> pistasEdificios, ILadron ladron);

    public String getNombre() {
        return nombre;
    }

    public String aceptar(Jugador jugador) {
        return jugador.visitar(this);
    }

    public String obtenerPista(Sargento sargento) {
        return pista.obtenerPistaDificil();
    }

    public String obtenerPista(Investigador investigador) {
        return pista.obtenerPistaDificil();
    }

    public String obtenerPista(Novato novato) {
        return pista.obtenerPistaFacil();
    }

    public String obtenerPista(Detective detective) {
        return pista.obtenerPistaMedia();
    }

    public String atraparLadron(Jugador jugador) {
        return jugador.atrapar(ladron);
    }

    public void esconderLadron(Ladron ladron) {
        this.ladron=ladron;
    }
}
