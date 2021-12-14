package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Senia;

import java.util.ArrayList;
import java.util.List;

public class Senia {

    private List<String> señas = new ArrayList<>();
    private Integer señaActual;

    public Senia() {
        señaActual = 0;
        señas.add("Sin Asignar");
        señas.add("Joyas");
        señas.add("Cicatriz");
        señas.add("Tatuaje");
        señas.add("Anillo");

    }

    public Boolean compararSeña(Senia seña) {
        return (seña.seña() == this.seña());
    }


    public String seña() {
        return señas.get(señaActual);
    }

    public void siguienteSeña() {
        señaActual++;
        if (señaActual >= señas.size()) {
            señaActual = 0;
        }

    }
}