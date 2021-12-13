package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;

public class Rojo implements Cabello{

    @Override
    public boolean compararCabello(Cabello cabello) {

        return (cabello.color() == "Rojo");
    }

    @Override
    public String color() {
        return "Rojo";
    }
}
