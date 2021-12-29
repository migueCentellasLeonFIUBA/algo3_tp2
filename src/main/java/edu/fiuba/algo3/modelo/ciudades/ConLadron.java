package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ConLadron implements IEstado{


    public ConLadron(){
    }

    @Override
    public String visitarEdificio(Edificio edificio, Jugador jugador) {
        edificio.atraparLadron(jugador);
        return "";
    }

    @Override
    public void agregarConexion(Mapa mapa, Ciudad ciudadAnterior) {

    }
}
