package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;

public class CabelloSinDefinir implements Cabello{

    @Override
    public boolean compararCabello(Cabello cabello) {
        return true;
    }

    @Override
    public String color() {
        return "Cabello Sin Definir";
    }
}
