package edu.fiuba.algo3.modelo.edificios;


import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ladron.ILadron;
import edu.fiuba.algo3.modelo.ladron.LadronNulo;

import java.util.Map;

public class Biblioteca extends Edificio  {
    public Biblioteca(IPista pista) {
        this.pista = pista;
        this.ladron= new LadronNulo();
    }

    @Override
    public void cambiarPista(Map<String, IPista> pistasEdificios, ILadron ladron) {
        this.pista = pistasEdificios.get("Biblioteca");
        this.pista.setLadron(ladron);
    }

    public String getNombre(){
        return "Biblioteca";
    }
}
