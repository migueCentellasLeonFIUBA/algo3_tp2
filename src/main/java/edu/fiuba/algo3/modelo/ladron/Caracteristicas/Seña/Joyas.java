package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña;

public class Joyas implements Seña{

    @Override
    public Boolean compararSeña(Seña seña) {
        return (seña.seña() == "Joyas");
    }

    @Override
    public String seña() {
        return "Joyas";
    }
}
