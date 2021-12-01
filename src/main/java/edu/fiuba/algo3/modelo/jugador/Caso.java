package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.ladron.*;

import java.util.List;


public class Caso {

    private List<Secuaz> sospechosos;
    private Ladron ladron;
    //private Rareza objetoRobado; //??


    public void setSospechosos(List<Secuaz> sospechosos) {
        this.sospechosos.addAll(sospechosos);
    }
    public void setLadron(Ladron ladron){
        this.ladron = ladron;
    }

/*
    public void setObjeto(Rareza rareza) {
        this.objetoRobado = rareza;
    }


 */

    //Operations

    public Secuaz BuscarSospechoso() {
        //TODO
        return new Secuaz();
    }
    
}
