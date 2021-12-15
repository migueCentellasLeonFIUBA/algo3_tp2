package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Senia;

import java.util.ArrayList;
import java.util.List;

public class Senia {

    private List<String> senias = new ArrayList<>();
    private Integer seniaActual;

    public Senia() {
        seniaActual = 0;
        senias.add("Sin Asignar");
        senias.add("Joyas");
        senias.add("Cicatriz");
        senias.add("Tatuaje");
        senias.add("Anillo");

    }

    public Boolean compararSeña(Senia seña) {
        return (seña.senia() == this.senia());
    }


    public String senia() {
        return senias.get(seniaActual);
    }

    public void siguienteSenia() {
        seniaActual++;
        if (seniaActual >= senias.size()) {
            seniaActual = 0;
        }

    }

    public Boolean estaAsignado(){
        return seniaActual == 0;
    }
}