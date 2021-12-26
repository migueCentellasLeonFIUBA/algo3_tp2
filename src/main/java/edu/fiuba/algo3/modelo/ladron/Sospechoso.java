package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.ManejoArchivos.IParser;

public class Sospechoso implements ISospechable{
    String nombre;
    Cualidades cualidades;

    public Sospechoso(String nombre,Cualidades cualidades){
        this.nombre=nombre;
        this.cualidades=cualidades;

    }
}
