package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.util.ArrayList;

public class Random {
    public String obtenerValorRandom(ArrayList<String> lista){
         return lista.get((int)(Math.random() * (lista.size() -1)));
    }
}
