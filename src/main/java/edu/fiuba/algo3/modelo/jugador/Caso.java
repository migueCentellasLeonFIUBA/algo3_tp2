package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.List;


public class Caso {

    private List<Secuaz> sospechosos;
    private Ladron ladron;
    private Objeto objetoRobado; //??

    private Caso() {

    }


    public static Caso crearCaso() {
        return new Caso();
    }


    public void setSospechosos(List<Secuaz> sospechosos) {
        this.sospechosos.addAll(sospechosos);
    }
    public void setLadron(Ladron ladron){
        this.ladron = ladron;
    }

    public void setObjeto(Objeto objeto) {
        this.objetoRobado = objeto;
    }

    public Ladron getLadron() {
        return ladron;
    }

    public Objeto getObjetoRobado() {
        return objetoRobado;
    }
    //Operations

    public Secuaz BuscarSospechoso() {
        //TODO
        return new Secuaz();
    }
    
}
