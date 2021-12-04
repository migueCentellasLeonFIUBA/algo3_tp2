package edu.fiuba.algo3.modelo.ladron;


import java.util.List;

public class Ladron implements Secuaces {

    private List<String> caracteristicas;
    private Estrategia estrategia;

    private Ladron(List<String> caracteristicas){
        this.caracteristicas =caracteristicas;
    }
    public static Ladron crear(List<String> caracteristicas) {
        return new Ladron(caracteristicas);
    }

    public void setCaracteristicas (List<String> caracteristicas) {
        this.caracteristicas.addAll(caracteristicas);
    }

    public void setEstrategia(Estrategia plan) {
        this.estrategia = plan;
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
