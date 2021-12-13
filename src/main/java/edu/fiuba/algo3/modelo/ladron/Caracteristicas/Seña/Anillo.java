package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña;

public class Anillo implements Seña{

    @Override
    public Boolean compararSeña(Seña seña) {
        return (seña.seña() == "Anillo");
    }

    @Override
    public String seña() {
        return "Anillo";
    }
}
