package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.rangos.*;

import java.io.FileNotFoundException;

public interface Edificio {

    String getNombre();

    Pista aceptar(Jugador jugador);

    Pista obtenerPista(Sargento sargento);

    Pista obtenerPista(Investigador investigador);

    Pista obtenerPista(Novato novato);

    Pista obtenerPista(Detective detective);
}
