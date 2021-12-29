package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.juego.Juego;

public class DirectorJuego {
    private ConstructorJuego constructor;

    public DirectorJuego(ConstructorJuego constructor){ this.constructor = constructor;}

    public void crearJuego(Fachada fachada) throws Exception {
        constructor.cargarObjetos(fachada);
        constructor.cargarCiudades(fachada);
        constructor.cargarMapa(fachada);
        constructor.cargarPistas(fachada);
        constructor.cargarSospechosos(fachada);
        constructor.cargarJugadores(fachada);
    }

    public Juego obtenerJuego(){
        return constructor.getJuego();
    }
}