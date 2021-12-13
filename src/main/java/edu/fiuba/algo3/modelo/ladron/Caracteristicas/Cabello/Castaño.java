package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;

public class Castaño implements Cabello{

    @Override
    public boolean compararCabello(Cabello cabello) {

        return (cabello.color() == "Castaño");
    }

    @Override
    public String color() {
        return "Castaño";
    }
}
