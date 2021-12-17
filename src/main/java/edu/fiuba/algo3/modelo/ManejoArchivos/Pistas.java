package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Pistas extends Archivo {

    public Pistas(String texto) {
        super(texto);
    }

    public void filtrarPistas(String unaCaracteristica){fachada.filtrar(unaCaracteristica);}

    public String ObtenerPista(String edificio){
        return pedirValor(edificio);
    }

}
