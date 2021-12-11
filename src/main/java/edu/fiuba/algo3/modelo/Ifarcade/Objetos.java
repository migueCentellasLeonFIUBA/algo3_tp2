package edu.fiuba.algo3.modelo.Ifarcade;

import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Objetos extends Archivo {
    private Fachada fachada;


    public Objetos(String texto){
        fachada = new Fachada(texto);
    }

    public void removerFiltros(){
         fachada.resetear();
    }

    private void filtrar(String termino){
        fachada.filtrar(termino);
    }

    private String pedirValor(String termino){
        return fachada.pedirValor(termino);
    }


}
