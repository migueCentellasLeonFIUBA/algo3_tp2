package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;

public class Negro implements Cabello{

    @Override
    public boolean compararCabello(Cabello cabello) {

        return (cabello.color() == "Negro");
    }

    @Override
    public String color() {
        return "Negro";
    }
}
