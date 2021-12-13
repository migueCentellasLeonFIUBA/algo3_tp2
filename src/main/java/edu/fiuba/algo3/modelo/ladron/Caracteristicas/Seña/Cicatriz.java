package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña;

public class Cicatriz implements Seña{

    @Override
    public Boolean compararSeña(Seña seña) {
        return (seña.seña() == "Cicatriz");
    }

    @Override
    public String seña() {
        return "Cicatriz";
    }
}
