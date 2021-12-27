package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ladron.ILadron;

import java.util.Map;

public class Banco implements IEdificio {
    IPista pista;

    public Banco(IPista pista) {
        this.pista = pista;
    }


    @Override
    public void cambiarPista(Map<String, IPista> pistasEdificios, ILadron ladron) {

    }
}
