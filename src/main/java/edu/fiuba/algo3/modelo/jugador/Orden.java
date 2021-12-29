package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.ISospechable;

public class Orden implements IOrden {

    ISospechable sospechoso;

    public Orden(ISospechable sospechoso){
        this.sospechoso = sospechoso;
    }

    public void revisarOrden(Jugador jugador){
        if(sospechoso.arrestar()){
            jugador.ganador();
        }else{
            jugador.perdedor();
        }
    }

    public String nombre(){
        return "Orden emitida para " + sospechoso.getNombre();
    }
}