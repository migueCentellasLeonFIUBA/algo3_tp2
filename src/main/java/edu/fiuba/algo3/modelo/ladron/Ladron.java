package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;

import java.util.List;

public class Ladron implements Secuaces {

    private List<String> caracteristicas;
    private Estrategia estrategia;

    public void setCaracteristicas (List<String> caracteristicas) {
        this.caracteristicas.addAll(caracteristicas);
    }

    public void setEstrategia(Estrategia plan) {
        this.estrategia = plan;
    }

    public void ataqueConCuchillo(Reloj relojJugador){
        relojJugador.ataqueConCuchillo();
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
