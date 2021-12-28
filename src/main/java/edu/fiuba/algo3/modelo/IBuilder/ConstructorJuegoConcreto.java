package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class ConstructorJuegoConcreto implements ConstructorJuego{

    private Juego juego;
    private Map<String, Ciudad> ciudades;
    private Mapa mapa;

    public ConstructorJuegoConcreto(){juego = new Juego();}

    @Override
    public void cargarObjetos(Fachada fachada) {
        Map<String, ArrayList<Objeto>> objetos = fachada.cargarObjetos();
        juego.setObjetos(objetos);
    }

    @Override
    public void cargarCiudades(Fachada fachada) {
        this.ciudades = fachada.cargarCiudades();
        juego.setCiudades(ciudades);
    }

    @Override
    public void cargarMapa(Fachada fachada) throws Exception {
        this.mapa = fachada.cargarMapa(ciudades);
        juego.setMapa(mapa);
    }

    @Override
    public void cargarJugadores(Fachada fachada) {
        Map<String, Jugador> jugadores = fachada.cargarJugadores(mapa);
        juego.setJugadores(jugadores);
    }

    @Override
    public void cargarPistas(Fachada fachada) {
        Map<String,Map<String, IPista>> pistas=fachada.cargarPistas();
        juego.setPistas(pistas);
    }

    @Override
    public void cargarSospechosos(Fachada fachada) {
        Map<String, ISospechable> sospechosos = fachada.cargarSospechosos();
        juego.setSospechosos(sospechosos);
    }

    @Override
    public Juego getJuego() {
        return juego;
    }
}