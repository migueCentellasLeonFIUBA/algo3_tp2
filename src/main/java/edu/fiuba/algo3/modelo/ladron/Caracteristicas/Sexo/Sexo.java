package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo;

import java.util.ArrayList;
import java.util.List;

public class Sexo {


    private List<String> sexos = new ArrayList<>();
    private Integer sexoActual;

    public Sexo() {
        sexoActual = 0;
        sexos.add("Sin Asignar"); //0
        sexos.add("Femenino"); //1
        sexos.add("Masculino"); //2
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

    public Boolean estaAsignado(){
        return sexoActual != 0;
    }

}

