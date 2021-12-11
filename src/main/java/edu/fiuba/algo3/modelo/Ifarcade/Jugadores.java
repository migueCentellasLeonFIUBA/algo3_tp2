package edu.fiuba.algo3.modelo.Ifarcade;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Jugadores extends Archivo {
    private Fachada fachada;

    public Jugadores(String texto){
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

    public Jugador pedirJugador(String nombre){
        fachada.filtrar(nombre);
        int arrestos = Integer.parseInt(fachada.pedirValor("Arrestos"));
        return new Jugador(arrestos,nombre);
    }
}
