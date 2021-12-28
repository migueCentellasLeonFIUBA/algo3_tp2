package edu.fiuba.algo3.modelo.ladron;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;

public class Cualidades {

    public ArrayList<String> caracteristicas;
    public ArrayList<String> caracteristicasUsadas;

    public Cualidades(ArrayList<String> caracteristicas){
        this.caracteristicas = caracteristicas;
        this.caracteristicasUsadas= new ArrayList<>();
        caracteristicasUsadas.add(caracteristicas.get(0));
    }

    public boolean comparar(ArrayList<String> caracteristicasABuscar){

        boolean esSospechoso = false;

        for(String caracteristica : caracteristicasABuscar){
            esSospechoso = caracteristicas.contains(caracteristica);
        }

        return esSospechoso;
    }

    public String dameUnaPista(){
        if(caracteristicasUsadas.size()==caracteristicas.size()){
            return "";
        }
        Randomizador random = new Randomizador();

        String caracteristicaRandom = random.obtenerStringRandom(caracteristicas);
        while(!caracteristicasUsadas.contains(caracteristicaRandom)){
            caracteristicaRandom = random.obtenerStringRandom(caracteristicas);
        }
        return "El ladrón tiene " + caracteristicaRandom;
    }

    public String obtenerSexo() {
        return caracteristicas.get(0);
    }
}
