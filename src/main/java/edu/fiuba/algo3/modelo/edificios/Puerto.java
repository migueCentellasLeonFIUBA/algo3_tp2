package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pistas.Dificil;
import edu.fiuba.algo3.modelo.pistas.Facil;
import edu.fiuba.algo3.modelo.pistas.Media;
import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.rangos.*;

import java.io.FileNotFoundException;


public class Puerto implements Edificio {

    private Facil pistaFacil;
    private Media pistaMedia;
    private Dificil pistaDificil;

    @Override
    public Pista obtenerPista(Sargento sargento) {
        return pistaDificil;
    }

    @Override
    public Pista obtenerPista(Investigador investigador) {
        return pistaMedia;
    }

    @Override
    public Pista obtenerPista(Novato novato) {
        return pistaFacil;
    }

    @Override
    public Pista obtenerPista(Detective detective) {
        return pistaDificil;
    }
    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public Pista aceptar(Jugador jugador) {
        return jugador.visitar(this);
    }

}
