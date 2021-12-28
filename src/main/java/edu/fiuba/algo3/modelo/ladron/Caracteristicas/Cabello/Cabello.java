package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello;


import java.util.ArrayList;
import java.util.List;

public class Cabello {

    private List<String> cabellos = new ArrayList<>();
    private Integer cabelloActual;

    public Cabello() {
        cabelloActual = 0;
        cabellos.add("Sin Asignar"); //0
        cabellos.add("Castaño"); //1
        cabellos.add("Rojo"); //2
        cabellos.add("Negro"); //3
        cabellos.add("Rubio"); //4
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


    public Boolean estaAsignado(){
        return cabelloActual != 0;
    }

    public String getCaracteristica(){
        return cabellos.get(cabelloActual);
    }
}

