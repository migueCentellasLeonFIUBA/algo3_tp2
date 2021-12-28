package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.ManejoArchivos.IParser;

import java.util.ArrayList;

public class Sospechoso implements ISospechable{
    String nombre;
    Cualidades cualidades;

    public Sospechoso(String nombre,Cualidades cualidades){
        this.nombre=nombre;
        this.cualidades=cualidades;
    }

    public Sospechoso comparar(ArrayList<String> caracteristicas) {
        if(cualidades.comparar(caracteristicas)){
            return this;
        }
        return null;
    }

    @Override
    public boolean arrestar() {
        return false;
    }

    public String dameUnaPista(){
        return cualidades.dameUnaPista();
    }

    @Override
    public String obtenerSexo() {
        return cualidades.obtenerSexo();
    }
}
