package edu.fiuba.algo3.modelo.Ifarcade;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Pistas extends Archivo {
    private Fachada fachada;

    public Pistas(String texto) {
        super(texto);
    }

    public String ObtenerPista(Edificio edificio){
        return pedirValor("");
    }

    public String PistasDeCiudad(Edificio Banco){
        return pedirValor("Banco");
    }

    @Override
    public Jugador pedirObjeto(String Objeto) {

        return null;
    }
}
