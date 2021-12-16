package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;

public class Jugadores extends Archivo {

    public Jugadores(String texto) {
        super(texto);
    }


    public Jugador pedirJugador(String nombre) {
        ArrayList<String> nombres = listaDeElementos();

        if(nombres.contains(nombre)){
            return (crearJugador(nombre, Integer.parseInt(fachada.pedirValor("Arrestos"))));
        }

        return crearJugador(nombre, 0);
    }

    private Jugador crearJugador(String nombre, Integer arrestos){
        return (new Jugador(nombre, arrestos));
    }
}
