package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.objetos.Objeto;
import java.util.Random;
import java.util.ArrayList;

public class Randomizador {

    public String obtenerStringRandom(ArrayList<String> lista){
        Random rand = new Random();
        int int_random = rand.nextInt(lista.size());
        return lista.get(int_random);
    }

    public Integer obtenerIntegerRandom(Integer listaSize){
        Random rand = new Random();
        int int_random = rand.nextInt(listaSize);
        return int_random;
    }

    public Objeto obtenerObjetoRandom(ArrayList<Objeto> lista){
        Random rand = new Random();
        int int_random = rand.nextInt(lista.size());
        return lista.get(int_random);
    }

}
