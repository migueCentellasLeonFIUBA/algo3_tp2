package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objeto.*;

import java.util.List;


public class Caso {

    private List<Secuaz> sospechosos;
    private Ladron ladron;
    private Objeto objetoRobado; //??


    private Caso(Ladron ladron, Objeto objeto){
        this.ladron = ladron;
        this.objetoRobado = objeto;
    }

    public static Caso crearCaso(Ladron ladron, Objeto objeto) {
        return new Caso(ladron, objeto);
    }

/*
    public void setSospechosos(List<Secuaz> sospechosos) {
        this.sospechosos.addAll(sospechosos);
    }
    public void setLadron(Ladron ladron){
        this.ladron = ladron;
    }


    public void setObjeto(Objeto objeto) {
        this.objetoRobado = objeto;
    }

    public void setObjetoRobado(Objeto objetoRobado) {
        this.objetoRobado = objetoRobado;
    }
*/
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
