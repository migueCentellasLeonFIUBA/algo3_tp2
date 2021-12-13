package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña;

public class Tatuaje implements Seña{

    @Override
    public Boolean compararSeña(Seña seña) {
        return (seña.seña() == "Tatuaje");
    }

    @Override
    public String seña() {
        return "Tatuaje";
    }
}
