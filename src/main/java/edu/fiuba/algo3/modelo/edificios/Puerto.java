package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.Pistas.SinPista;
import edu.fiuba.algo3.modelo.ladron.ILadron;

import java.util.Map;


public class Puerto implements IEdificio {
    IPista pista;

    public Puerto(IPista pista) {
        this.pista = new SinPista();
    }

    @Override
    public void cambiarPista(Map<String, IPista> pistasEdificios, ILadron ladron) {

    }
}
