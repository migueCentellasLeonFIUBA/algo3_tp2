package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;

public class AeroPuerto implements IEdificio {
    IPista pista;

    public AeroPuerto(IPista pista) {
        this.pista = pista;
    }

}
