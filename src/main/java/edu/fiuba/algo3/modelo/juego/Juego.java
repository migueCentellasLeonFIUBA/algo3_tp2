package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Juego {

    private Map<String, ArrayList<Objeto>> objetos;
    private Map<String, Ciudad> ciudades;
    private Map<String, Jugador> jugadores;
    private  Map<String,Map<String, IPista>> pistas;
    private Map<String, ISospechable> sospechosos;
    private Map<Ciudad, ArrayList<Ciudad>> conexiones;
    private Mapa mapa;

    private Jugador jugadorActual;

    public void setObjetos(Map<String, ArrayList<Objeto>> objetos) {
        this.objetos = objetos;
    }

    public void setPistas(Map<String,Map<String, IPista>> pistas) {
        this.pistas = pistas;
    }

    public void setCiudades(Map<String, Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public void setJugadores(Map<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void setSospechosos(Map<String, ISospechable> sospechosos) {
        this.sospechosos = sospechosos;
    }

    public Jugador IdentificarJugador(String nombre) {
        if (jugadores.containsKey(nombre)){
            this.jugadorActual= jugadores.get(nombre);
            return jugadorActual;
        }

        jugadorActual = new Jugador(nombre,0,new Reloj(),mapa);
        return jugadorActual;
    }

    private Ladron crearLadron(Map<String, ISospechable> sospechosos){
        Randomizador random = new Randomizador();
        String nombre = random.obtenerStringRandom(new ArrayList<String>(sospechosos.keySet()));
        Ladron ladron = new Ladron(sospechosos.get(nombre));
        sospechosos.put(nombre,ladron);
        return ladron;
    }

    public void comenzarCaso() throws Exception {
        if(jugadorActual == null) throw new Exception("Identificar un jugador antes de crear un caso");

        Computadora computadora = new Computadora(sospechosos);
        Ladron ladron = crearLadron(sospechosos);
        Objeto objeto = jugadorActual.ObjetoRobado(objetos);

        Caso caso = new Caso(computadora,ladron,objeto);

        jugadorActual.empezarCaso(caso);

        objeto.aplicarEstrategia(ciudades,pistas,ladron,mapa);


    }

}
