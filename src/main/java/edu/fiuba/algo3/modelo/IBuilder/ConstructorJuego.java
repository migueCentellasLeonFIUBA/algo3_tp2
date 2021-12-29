package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.juego.Juego;


public interface ConstructorJuego {
    void cargarObjetos(Fachada fachada);
    void cargarCiudades(Fachada fachada);
    void cargarJugadores(Fachada fachada);
    void cargarMapa(Fachada fachada) throws Exception;
    void cargarPistas(Fachada fachada);
    void cargarSospechosos(Fachada fachada);

    Juego getJuego();
}