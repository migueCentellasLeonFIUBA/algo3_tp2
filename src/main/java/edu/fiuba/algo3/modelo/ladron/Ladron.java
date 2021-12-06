package edu.fiuba.algo3.modelo.ladron;


import java.util.List;

public class Ladron implements Secuaces {

    private List<String> caracteristicas;

    private Ladron(List<String> caracteristicas, Estrategia estrategia){
        this.caracteristicas =caracteristicas;

    }
    public static Ladron crear(List<String> caracteristicas, Estrategia estrategia) {
        return new Ladron(caracteristicas, estrategia);
    }

    public void setCaracteristicas (List<String> caracteristicas) {
        this.caracteristicas.addAll(caracteristicas);
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
