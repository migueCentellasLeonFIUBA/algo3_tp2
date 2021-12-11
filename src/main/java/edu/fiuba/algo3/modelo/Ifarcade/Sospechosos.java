package edu.fiuba.algo3.modelo.Ifarcade;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Sospechosos extends Archivo {

    public Sospechosos(String texto) {
        super(texto);
    }

    public String ObtenerPista(Edificio edificio){
        return pedirValor("");
    }

    public String PistasDeCiudad(Edificio Banco){
        return pedirValor("Banco");
    }

    public Ladron ObtenerLadron() {
        ArrayList<String> nombres = listaDeElementos();
        filtrar(nombres.get(0));

    }

}
