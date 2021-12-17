package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Pistas extends Archivo {
    private Fachada fachada;

    public Pistas(String texto) {
        super(texto);
    }

    public String ObtenerPista(String edificio){
        return pedirValor(edificio);
    }

}
