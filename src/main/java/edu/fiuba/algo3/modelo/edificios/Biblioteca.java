package edu.fiuba.algo3.modelo.edificios;


import edu.fiuba.algo3.modelo.Pistas.IPista;

public class Biblioteca implements IEdificio {
    IPista pista;

    public Biblioteca(IPista pista) {
        this.pista = pista;
    }
}
