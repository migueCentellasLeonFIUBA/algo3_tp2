package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;

public class Juego {

    private Sospechosos sospechosos;
    private Jugadores jugadores;
    private Ciudades ciudades;
    private Objetos objetos;

    private ArrayList<Ciudad> listaCiudades;
    private Jugador jugadorActual;
    private GestorDeArchivos gestorArchivos;


    public Juego(IFachada fachada){
        sospechosos = new Sospechosos(fachada.nuevoParser());

        fachada.cargar(sospechosos)//habla con la fachada la fachada sabe que de sospechosos tiene que cargar un file en especifico

        //a todo esto la fachada usa el gestor de archivos para leer la ruta y enviarle cargar a sospechosos que va a llenar al parser.


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

        cargarPistas();
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
