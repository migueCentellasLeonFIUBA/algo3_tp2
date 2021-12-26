package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Juego {

    private Fachada fachada;
    private Map<String, ArrayList<Objeto>> objetos;
    private Map<String, Ciudad> ciudades;
    private Map<String, Jugador> jugadores;
    //private Map<String, Jugador> jugadores;

    private Jugador jugadorActual;

    public Juego(Fachada fachada){
        this.fachada = fachada;
        this.objetos = fachada.cargarObjetos();
        this.ciudades = fachada.cargarCiudades();
        this.jugadores = fachada.cargarJugadores();

    }

    public Jugador IdentificarJugador(String nombre) {
        if (jugadores.containsKey(nombre)){
            this.jugadorActual= jugadores.get(nombre);
            return jugadorActual;
        }

        jugadorActual = new Jugador(nombre,0);
        return jugadorActual;
    }

    public void crearCaso(){
        Computadora computadora = new Computadora(fachada.cargarSospechosos());
        jugadorActual.empezarCaso();


        //jugador Empezar caso -> al caso le paso mi grado.
        //Caso le dice a grado -> dame un objeto robado.
        //Grado policia le dice al Juego dame un objeto robado
        //Juego a la fachada dame un objeto aleatorio con tipo "comun"
        //fachada dame uno aleatorio "comun"
    }

}
