package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.ISospechable;

public class Orden implements IOrden {

    ISospechable sospechoso;

    public Orden(ISospechable sospechoso){
        this.sospechoso = sospechoso;
    }

    public boolean arrestar(){
        return sospechoso.arrestar();
    }
}