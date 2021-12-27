package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.Pistas.IPista;

public class Banco implements IEdificio {
    IPista pista;

    public Banco(IPista pista) {
        this.pista = pista;
    }


}
