package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Random {

    public String obtenerStringRandom(ArrayList<String> lista){
         return lista.get((int)(Math.random() * (lista.size() -1)));
    }

    public Integer obtenerIntegerRandom(Integer listaSize){
        return (int)(Math.random() * (listaSize -1));
    }

    public Objeto obtenerObjetoRandom(ArrayList<Objeto> lista){
        return lista.get((int)(Math.random() * (lista.size() -1)));
    }

}
