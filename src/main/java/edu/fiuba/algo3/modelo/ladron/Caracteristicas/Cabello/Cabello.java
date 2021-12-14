package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;

import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;

import java.util.ArrayList;
import java.util.List;

public class Cabello {

    private List<String> cabellos = new ArrayList<>();
    private Integer cabelloActual;

    public Cabello() {
        cabelloActual = 0;
        cabellos.add("Sin Asignar");
        cabellos.add("Castaño");
        cabellos.add("Rojo");
        cabellos.add("Negro");
        cabellos.add("Rubio");
    }



    public String cabello() {
        return cabellos.get(cabelloActual);
    }

    public void siguienteCabello() {
        cabelloActual++;
        if (cabelloActual >= cabellos.size()) {
            cabelloActual = 0;
        }
    }

}

