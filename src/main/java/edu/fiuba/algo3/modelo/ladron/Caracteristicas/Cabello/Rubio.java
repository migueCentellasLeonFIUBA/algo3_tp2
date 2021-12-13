package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;

import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;

public class Rubio implements Cabello {

    @Override
    public boolean compararCabello(Cabello cabello) {

        return (cabello.color() == "Rubio");
    }

    @Override
    public String color() {
        return "Rubio";
    }
}


