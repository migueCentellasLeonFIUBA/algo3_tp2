package edu.fiuba.algo3.modelo.ladron;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ladron implements Secuaces {

    private List<String> caracteristicas = new ArrayList<>();

    private Ladron(List<String> caracteristicas, Estrategia estrategia){
        this.caracteristicas =caracteristicas;

    }

    public static Ladron crear(List<String> caracteristicas, Estrategia estrategia) {
        return new Ladron(caracteristicas, estrategia);
    }

    //hago los metodos para que compile
    public static Ladron crear(List<String> caracteristicas) {
        return new Ladron(caracteristicas);
    }

    private Ladron(List<String> caracteristicas){
        this.caracteristicas =caracteristicas;
    }


    //Operations
    @Override
    public boolean Arrestar() {
        //TODO
        return true;
    }

    @Override
    public boolean Sospechar() {
        //TODO
        return false;
    }
    
}
