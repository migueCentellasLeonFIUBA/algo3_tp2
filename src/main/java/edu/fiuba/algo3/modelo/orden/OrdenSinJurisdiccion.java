package edu.fiuba.algo3.modelo.orden;

import edu.fiuba.algo3.modelo.ladron.Secuaces;

public class OrdenSinJurisdiccion implements Ordenes {

    @Override
    public Ordenes emitirOrden(Secuaces ladron){
        //Si es un Ladron -> creo una nueva orden...
        if(ladron.arrestar()){
            OrdenDeArresto orden = new OrdenDeArresto();
            orden.emitirOrden(ladron);
            return orden;
        }
        return this; //era un secuaz.
    }

    @Override
    public boolean arrestarLadron(Secuaces arrestado){
        return false; //no hay orden para arrestar
    }
}
