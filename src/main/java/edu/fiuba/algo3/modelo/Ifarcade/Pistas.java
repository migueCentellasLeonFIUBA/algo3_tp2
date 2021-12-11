package edu.fiuba.algo3.modelo.Ifarcade;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Pistas implements Archivo {
    private Fachada fachada;


    public Pistas(String texto){
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

    public String ObtenerPista(Edificio edificio){
        return pedirValor("");
    }

    public String PistasDeCiudad(Edificio Banco){
        return pedirValor("Banco");
    }
}
