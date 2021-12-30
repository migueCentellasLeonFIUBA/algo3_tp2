package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.ISospechable;

public class Orden implements IOrden {

    ISospechable sospechoso;

    public Orden(ISospechable sospechoso){
        this.sospechoso = sospechoso;
    }

    public String revisarOrden(Jugador jugador){
        if(sospechoso.arrestar()){
            jugador.ganador();
            return " y orden correcta, ganaste la partida. Muy bien hecho";
        }else{
            jugador.perdedor();
            return ", orden emitida para el Sospechoso equivocado, perdió el juego.";
        }
    }

    public String nombre(){
        return "Orden emitida para " + sospechoso.getNombre();
    }
}