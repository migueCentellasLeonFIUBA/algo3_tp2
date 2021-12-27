package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.NoOrden;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Juego {

    private Fachada fachada;
    private Map<String, ArrayList<Objeto>> objetos;
    private Map<String, Ciudad> ciudades;
    private Map<String, Jugador> jugadores;
    private Map<Ciudad, ArrayList<Ciudad>> conexiones;
    private Mapa mapa;

    private Jugador jugadorActual;

    public Juego(Fachada fachada){
        this.fachada = fachada;
        this.objetos = fachada.cargarObjetos();
        this.ciudades = fachada.cargarCiudades();
        this.jugadores = fachada.cargarJugadores();
        this.conexiones = fachada.cargarConexiones(ciudades);
    }

    private Mapa cargarMapa(Map<Ciudad, ArrayList<Ciudad>> conexiones, Jugador jugador){
        return new Mapa(conexiones, jugador);
    }

    public Jugador IdentificarJugador(String nombre) {
        if (jugadores.containsKey(nombre)){
            this.jugadorActual= jugadores.get(nombre);
        }
        else{
            jugadorActual = new Jugador(nombre,0, new NoOrden());
            jugadores.put(nombre, jugadorActual);
        }


        this.mapa = this.cargarMapa(conexiones, jugadorActual); //depende del jugador.
        return jugadorActual;
    }

    private Ladron crearLadron(Map<String, ISospechable> sospechosos){
        Random random = new Random();
        String nombre = random.obtenerValorRandom((ArrayList<String>) sospechosos.keySet());
        Ladron ladron = new Ladron(sospechosos.get(nombre));
        sospechosos.put(nombre,ladron);
        return ladron;
    }

    public void crearCaso(){
        Map<String, ISospechable> sospechosos = fachada.cargarSospechosos();
        Computadora computadora = new Computadora(sospechosos);
        Ladron ladron = crearLadron(sospechosos);
        Objeto objeto = jugadorActual.ObjetoRobado(objetos);
        objeto.aplicarEstrategia(ciudades);
        Caso caso = new Caso(objeto,ladron);
        jugadorActual.empezarCaso(caso,computadora);

        //jugador Empezar caso -> al caso le paso mi grado.
        //Caso le dice a grado -> dame un objeto robado.
        //Grado policia le dice al Juego dame un objeto robado
        //Juego a la fachada dame un objeto aleatorio con tipo "comun"
        //fachada dame uno aleatorio "comun"
    }

}
