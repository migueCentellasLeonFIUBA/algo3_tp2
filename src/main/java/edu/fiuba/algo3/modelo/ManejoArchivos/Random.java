package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.util.ArrayList;

public class Random {

    public int obtenerNumeroRandom(ArrayList<String> lista){
         return (int)(Math.random() * (lista.size() -1));
    }

    public int obtenerNumeroRandom(int tope){return (int)(Math.random() * (tope -1));}
}
