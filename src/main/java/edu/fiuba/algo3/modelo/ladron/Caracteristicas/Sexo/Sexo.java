package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo;

import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Sexo {


    private List<String> sexos = new ArrayList<>();
    private Integer sexoActual;

    public Sexo() {
        sexoActual = 0;
        sexos.add("Sin Asignar");
        sexos.add("Femenino");
        sexos.add("Masculino");


    }

    public Boolean compararSexo(Sexo sexo) {
        return (sexo.sexo() == this.sexo());
    }


    public String sexo() {
        return sexos.get(sexoActual);
    }

    public void siguienteSexo() {
        sexoActual++;
        if (sexoActual >= sexos.size()) {
            sexoActual = 0;
        }
    }
}

