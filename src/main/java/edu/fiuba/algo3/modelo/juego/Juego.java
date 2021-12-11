package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.Ifarcade.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.io.*;

public class Juego {

    private Sospechosos sospechosos;
    private Jugadores jugadores;
    private Ciudades ciudades;
    private Pistas pistas;
    private Objetos objetos;

    private Jugador jugadorActual;
    private GestorDeArchivos gestorArchivos;


    public Juego() throws Exception {
        gestorArchivos = new GestorDeArchivos();
/*
        cargarPistas("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json");
        cargarObjetos("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json");
        cargarJugadores("src/main/java/edu/fiuba/algo3/Archivos/Jugadores.json");
        cargarSospechosos("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json");
        cargarCiudades("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json");
*/

        cargarArchivo("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json", pistas);
        cargarArchivo("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json", objetos);
        cargarArchivo("src/main/java/edu/fiuba/algo3/Archivos/Jugadores.json", jugadores);
        cargarArchivo("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json", sospechosos);
        cargarArchivo("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json", ciudades);


    }

    public void cargarArchivo(String ruta, Archivo archivo) throws FileNotFoundException {
        String texto = gestorArchivos.leerTextoCompleto(ruta);
        //archivo = new Archivo(texto); //No se pueden crear objetos de la superclase
        archivo.crearArchivo(texto);

    }
    public void cargarObjetos(String ruta) throws FileNotFoundException {
        String texto = gestorArchivos.leerTextoCompleto(ruta);
        objetos = new Objetos(texto);
    }

    public void cargarPistas(String ruta) throws FileNotFoundException {
        String texto = gestorArchivos.leerTextoCompleto(ruta);
        pistas = new Pistas(texto);
    }

    private void cargarJugadores(String ruta) throws FileNotFoundException {
        String texto = gestorArchivos.leerTextoCompleto(ruta);
        jugadores = new Jugadores(texto);
    }

    public void cargarSospechosos(String ruta) throws FileNotFoundException {
        String texto = gestorArchivos.leerTextoCompleto(ruta);
        sospechosos = new Sospechosos(texto);
    }

    public void cargarCiudades(String ruta) throws FileNotFoundException {
        String texto = gestorArchivos.leerTextoCompleto(ruta);
        ciudades = new Ciudades(texto);
    }

    public Jugador IdentificarJugador(String nombre) {

        Jugador jugador = jugadores.pedirObjeto(nombre); //sería parte de la interfaz como pedir pista

        //IF de decisión del usuario
        this.jugadorActual = new Jugador(nombre, 0);

        return (this.jugadorActual);

        // Posible refactor -> return jugadores.stream().anyMatch("aaaa");;
    }

    public void TerminarJuego() {
        //TODO
    }

    public void crearCaso() throws Exception {

        //Serian de la misma interfaz.

        Ladron ladronRandom = sospechosos.ObtenerRandom();
        Ciudad ciudadRandom = ciudades.ObtenerRandom(); // esto no lo vamos a necesitar
        Objeto objetoRandom = objetos.ObtenerRandom();

        jugadorActual.empezarCaso(new Caso(ladronRandom, objetoRandom, ciudadRandom), ciudadRandom);

    }



}
