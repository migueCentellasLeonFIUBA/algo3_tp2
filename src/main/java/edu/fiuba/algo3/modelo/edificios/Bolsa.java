package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.Pistas.IPistas;
import edu.fiuba.algo3.modelo.Pistas.SinPista;

public class Bolsa implements IEdificio {
    IPistas pista;

    public Bolsa() {
        this.pista = new SinPista();
    }
}
