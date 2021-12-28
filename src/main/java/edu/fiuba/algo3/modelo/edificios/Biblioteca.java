package edu.fiuba.algo3.modelo.edificios;


import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ladron.ILadron;
import edu.fiuba.algo3.modelo.ladron.LadronNulo;

import java.util.Map;

public class Biblioteca extends Edificio  {
    public Biblioteca(IPista pista) {
        this.pista = pista;
        this.ladron= new LadronNulo();
        super.nombre = "Biblioteca";
    }

    @Override
    public void cambiarPista(Map<String, IPista> pistasEdificios, ILadron ladron) {
        this.pista = pistasEdificios.get("Biblioteca");
        this.pista.setLadron(ladron);
    }
}
