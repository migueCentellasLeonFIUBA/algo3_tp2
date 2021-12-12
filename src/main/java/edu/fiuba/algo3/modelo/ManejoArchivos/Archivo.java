package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.util.ArrayList;

public abstract class Archivo {

    protected Fachada fachada;

    public Archivo(String texto) {
        fachada = new Fachada(texto);
    }

    public void removerFiltros(){
        fachada.resetear();
    }

    protected void filtrar(String termino){
        fachada.filtrar(termino);
    }

    protected String pedirValor(String termino){return fachada.pedirValor(termino);}

    protected ArrayList<String> listaDeElementos(){
        return fachada.listaDeElementos();
    }

}
