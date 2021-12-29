package edu.fiuba.algo3.modelo.jugador;

public class NoOrden implements IOrden{

    public String revisarOrden(Jugador jugador){
        jugador.perdedor();
        return " pero usted no tiene la orden cargada, perdió el juego.";
    }
}