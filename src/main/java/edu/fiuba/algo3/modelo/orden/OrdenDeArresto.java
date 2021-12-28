package edu.fiuba.algo3.modelo.orden;

import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaces;

public class OrdenDeArresto implements Ordenes{

    Secuaces ladron;

    @Override
    public Ordenes emitirOrden(Secuaces ladron){
        this.ladron = ladron;
        return this; //ya se tiene una orden.
    }

    @Override
    public boolean arrestarLadron(Secuaces arrestado){
        return (arrestado.arrestar());
    }
}
