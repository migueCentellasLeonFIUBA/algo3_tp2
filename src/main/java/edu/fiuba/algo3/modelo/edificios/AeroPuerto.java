package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPistas;
import edu.fiuba.algo3.modelo.Pistas.SinPista;

public class AeroPuerto implements IEdificio {
    IPistas pista;

    public AeroPuerto() {
        this.pista = new SinPista();
    }

}
