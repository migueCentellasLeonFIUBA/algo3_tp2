package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Pistas extends Archivo {


    public Pistas(String texto) {
        super(texto);
    }

    public String ObtenerPista(String edificio){
        String pista = pedirValor(edificio);

        return pista;
    }

    public void filtrarGrados(String unGrado){fachada.filtrar(unGrado);}

    public void filtrarCiudades(String unaCiudad){fachada.volverAFiltrar(unaCiudad);}

}