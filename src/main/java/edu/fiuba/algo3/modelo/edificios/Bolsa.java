package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.Pistas.SinPista;

public class Bolsa implements IEdificio {
    IPista pista;

    public Bolsa(IPista pista) {
        this.pista = new SinPista();
    }
}
