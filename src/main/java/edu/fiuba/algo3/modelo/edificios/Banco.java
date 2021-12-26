package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.Pistas.IPistas;
import edu.fiuba.algo3.modelo.Pistas.SinPista;
import edu.fiuba.algo3.modelo.ciudades.Coordenadas;

import java.util.ArrayList;

public class Banco implements IEdificio {
    IPistas pista;

    public Banco(IPistas pista) {
        this.pista = pista;
    }


}
