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
            return " y orden correcta, ganaste la partida.";
        }else{
            jugador.perdedor();
            return " orden creada para el Sospechoso equivocado, cuidado nos pueden demandar por hacer esto.";
        }
    }
}