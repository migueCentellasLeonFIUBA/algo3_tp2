package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.Pistas.SinPista;


public class Puerto implements IEdificio {
    IPista pista;

    public Puerto(IPista pista) {
        this.pista = new SinPista();
    }

}
