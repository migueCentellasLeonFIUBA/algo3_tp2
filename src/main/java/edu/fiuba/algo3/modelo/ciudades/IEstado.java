package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public interface IEstado {
    String visitarEdificio(Edificio edificio, Jugador jugador);

    public void agregarConexion(Mapa mapa, Ciudad ciudadAnterior);
}
