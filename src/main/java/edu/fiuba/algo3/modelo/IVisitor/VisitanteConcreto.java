package edu.fiuba.algo3.modelo.IVisitor;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

public class VisitanteConcreto implements Visitante{

    private final GradoPolicia grado;

    public VisitanteConcreto(GradoPolicia unGrado){
        this.grado = unGrado;
    }

    @Override
    public String visitar(AeroPuerto aeropuerto){
        return "Pista Aeropuerto";
    }

    @Override
    public String visitar(Banco banco) {
        return "Pista Banco";
    }

    @Override
    public String visitar(Biblioteca biblioteca) {
        return "Pista Biblioteca";
    }

    @Override
    public String  visitar(Bolsa bolsa) {
        return "Pista Bolsa";
    }

    @Override
    public String  visitar(Puerto puerto) {
        return "Pista Puerto";
    }

}
