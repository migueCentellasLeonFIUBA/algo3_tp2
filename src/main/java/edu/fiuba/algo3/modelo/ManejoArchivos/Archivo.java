package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.util.ArrayList;

public abstract class Archivo {

    protected IParser parser;

    public Archivo(IParser parserNuevo) {
        parser = parserNuevo;
    }

    protected void filtrar(String termino){
        parser.filtrar(termino);
    }

    protected String pedirValor(String termino){return parser.pedirValor(termino);}

    protected ArrayList<String> listaDeElementos(){
        return parser.listaDeElementos();
    }

}
