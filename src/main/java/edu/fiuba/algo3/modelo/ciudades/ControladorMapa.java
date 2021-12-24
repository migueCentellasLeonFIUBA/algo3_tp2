package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//se encarga de mediar entre el mapa y el jugador, los viajes a realizar.
public class ControladorMapa {

    private Mapa mapa;
    private Jugador jugador;
    private Juego juego;

    public ControladorMapa(Mapa mapa, Jugador jugador, Juego juego){
        this.mapa = mapa;
        this.jugador = jugador;
        this.juego = juego;
    }

    //captura un pais del mapa y se la devuelve al jugador, para que haga un viaje:
    public void viajarACiudad(String nombre){

        //capturo la instancia de ciudad correspondiente:
        Ciudad destino = mapa.getCiudad(nombre);

        //se le envia la instancia de ciudad al jugador:
        jugador.viajarACiudad(destino);
    }

}
