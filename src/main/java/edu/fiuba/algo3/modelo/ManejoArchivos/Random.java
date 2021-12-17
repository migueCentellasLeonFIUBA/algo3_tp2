package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;

import java.util.ArrayList;

public class Random {

    public int obtenerNumeroRandom(ArrayList<String> lista){
         return (int)(Math.random() * (lista.size() -1));
    }

    public int obtenerNumeroRandomCiudad(ArrayList<Ciudad> lista){
        return (int)(Math.random() * (lista.size() -1));
    }
}
