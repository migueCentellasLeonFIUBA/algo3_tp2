package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Ladron;

public class ConLadron implements IEstado{

    public ISospechable ladron;

    public ConLadron(Ladron ladron){
        this.ladron=ladron;
    }

    @Override
    public String visitarEdificio(Edificio edificio, Jugador jugador) {
        return null;
    }

    @Override
    public void agregarConexion(Mapa mapa, Ciudad ciudadAnterior) {

    }
}
