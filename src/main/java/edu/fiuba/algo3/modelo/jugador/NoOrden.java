package edu.fiuba.algo3.modelo.jugador;

public class NoOrden implements IOrden{

    public void revisarOrden(Jugador jugador){
        jugador.perdedor();
    }
}