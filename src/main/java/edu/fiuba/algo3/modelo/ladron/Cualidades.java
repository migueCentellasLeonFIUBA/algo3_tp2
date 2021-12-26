package edu.fiuba.algo3.modelo.ladron;

import java.util.ArrayList;

public class Cualidades {

    public ArrayList<String> caracteristicas;

    public Cualidades(ArrayList<String> caracteristicas){
        this.caracteristicas = caracteristicas;
    }

    public boolean comparar(ArrayList<String> caracteristicasABuscar){

        boolean esSospechoso = false;

        for(String caracteristica : caracteristicasABuscar){
            esSospechoso = caracteristicas.contains(caracteristica);
        }

        return esSospechoso;
    }

}
