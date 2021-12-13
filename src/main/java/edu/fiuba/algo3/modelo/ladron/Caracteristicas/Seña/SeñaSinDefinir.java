package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña;

public class SeñaSinDefinir implements Seña{

    @Override
    public Boolean compararSeña(Seña seña) {
        return true;
    }

    @Override
    public String seña() {
        return "Seña Sin Definir";
    }
}
