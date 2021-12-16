package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.io.*;
import java.util.ArrayList;

public class Juego {

    private Sospechosos sospechosos;
    private Jugadores jugadores;
    private Ciudades ciudades;
    private Pistas pistas;
    private Objetos objetos;

    private ArrayList<Ciudad> listaCiudades;
    private Jugador jugadorActual;
    private GestorDeArchivos gestorArchivos;


    public Juego() throws Exception {
        gestorArchivos = new GestorDeArchivos();
        cargarPistas();
        cargarObjetos();
        cargarJugadores();
        cargarSospechosos();
        cargarCiudades();
    }

    private String obtenerTexto(String ruta) throws FileNotFoundException {
        return gestorArchivos.leerTextoCompleto(ruta);
    }

    private void cargarObjetos() throws FileNotFoundException {
        objetos = new Objetos(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
    }

    private void cargarPistas() throws FileNotFoundException {
        pistas = new Pistas(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json"));
    }

    private void cargarJugadores() throws FileNotFoundException {
        jugadores = new Jugadores(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Jugadores.json"));
    }

    private void cargarSospechosos() throws FileNotFoundException {
        sospechosos = new Sospechosos(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
    }

    private void cargarCiudades() throws FileNotFoundException {
       ciudades = new Ciudades(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
       listaCiudades = ciudades.crearCiudades();
    }

    public Jugador IdentificarJugador(String nombre) {

        jugadorActual = jugadores.pedirJugador(nombre); //sería parte de la interfaz como pedir pista
        return (this.jugadorActual);

    }

    public void TerminarJuego() {
        //TODO
    }

    public void crearCaso() throws Exception {

        //Serian de la misma interfaz.
        Ladron ladronRandom = sospechosos.ObtenerLadronRandom();
        Ciudad ciudadRandom = this.ObtenerCiudadRandom(); // esto no lo vamos a necesitar
        Objeto objetoRandom = objetos.ObtenerObjetoRandom();

        jugadorActual.empezarCaso(new Caso(ladronRandom, objetoRandom, ciudadRandom, ciudades), ciudadRandom);

    }

    private Ciudad ObtenerCiudadRandom() {
        int posicionRandom = ciudades.ObtenerPosicionCiudadRandom();
        return listaCiudades.get(posicionRandom);
    }


    public Jugador getJugador() {
        return jugadorActual;
    }
}
