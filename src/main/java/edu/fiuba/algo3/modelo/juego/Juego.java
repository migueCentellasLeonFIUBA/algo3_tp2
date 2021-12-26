package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.*;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Juego {

    private Sospechosos sospechosos;
    private Jugadores jugadores;
    private Ciudades ciudades;
    private Objetos objetos;

    private Mapa mapa;
    private CiudadesMapa ciudadesMapa;

    private ArrayList<Ciudad> listaCiudades;
    private Jugador jugadorActual;
    private GestorDeArchivos gestorArchivos;
    private Map<String, Ruta> rutas;

    public Juego() throws Exception {
        gestorArchivos = new GestorDeArchivos();
        rutas = new HashMap<>();
        cargarObjetos();
        cargarJugadores();
        cargarSospechosos();
        cargarCiudades();
        cargarMapa();
        cargarRutas();
    }

    private void cargarRutas() {
        //lee todas las rutas del archivo.
        //rutas = fachada.algo ("src/main/java/edu/fiuba/algo3/Archivos/Rutas.json");
    }

    private String obtenerTexto(String ruta) throws FileNotFoundException {
        return gestorArchivos.leerTextoCompleto(ruta);
    }

    private void cargarObjetos() throws FileNotFoundException {
        objetos = new Objetos(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
    }

    private void cargarPistas() throws FileNotFoundException {
        Pistas pistas = new Pistas(obtenerTexto("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json"));
        jugadorActual.cargarPistas(pistas);
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

    //crea toda la lista de ciudades del mapa, que se usará para todos los casos.
    public Mapa cargarMapa(){
        //Para cargar el mapa necesito que esten cargadas las conexiones en cada ciudad...
        ciudadesMapa = new CiudadesMapa(listaCiudades);
        this.mapa = new Mapa(ciudadesMapa);
        return mapa;
    }

    public Jugador IdentificarJugador(String nombre) {

        jugadorActual = jugadores.pedirJugador(nombre); //sería parte de la interfaz como pedir pista
        return (this.jugadorActual);
    }

    public void TerminarJuego() {
        //TODO
    }

    //crea el caso y devuelve la ciudad inicial para mostar el primer mapa.
    public Ciudad crearCaso() throws Exception {

        //Serian de la misma interfaz.
        Ladron ladronRandom = sospechosos.ObtenerLadronRandom();
        //Ciudad ciudadOrigen = this.ObtenerCiudadRandom();       //esto no lo vamos a necesitar.

        Objeto objetoRandom = jugadorActual.obtenerObjetoRandom(objetos);
        String origen = objetoRandom.getCiudadOrigen();
        Ciudad ciudadOrigen = mapa.getCiudad(origen);

        //Rutas, las rutas quedan definidas por el objeto:
        Ruta ruta = rutas.get(objetoRandom.getNombre());

        cargarPistas();
        //jugadorActual.empezarCaso(ladronRandom, objetoRandom, ciudadOrigen, ciudades, sospechosos);

        jugadorActual.empezarCaso(ladronRandom, objetoRandom, ciudadOrigen, sospechosos, ruta);
        return ciudadOrigen;
    }

    private Ciudad ObtenerCiudadRandom() {
        int posicionRandom = ciudades.ObtenerPosicionCiudadRandom();
        return listaCiudades.get(posicionRandom);
    }

    public Jugador getJugador() {
        return jugadorActual;
    }
}
