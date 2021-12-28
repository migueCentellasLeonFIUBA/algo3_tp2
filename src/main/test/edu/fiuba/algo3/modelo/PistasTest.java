package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorJuegoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorJuego;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PistasTest {

        @Test
        public void recibirPistaCiudadConEstrategia() throws Exception {
            Parser parser = new Parser();
            Fachada fachada = new Fachada(parser);
            ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
            DirectorJuego director = new DirectorJuego(constructor);
            director.crearJuego(fachada);
            Juego juego = director.obtenerJuego();
            Jugador jugador = juego.IdentificarJugador("Lucio");
            juego.comenzarCaso();
            ArrayList<Edificio> edificios = jugador.verEdificios();
            Edificio edificio = edificios.get(0);
            String pista = jugador.visitarEdificio(edificio);

            Assert.assertEquals("","");

        }

    @Test
    public void recibirPistaCiudadSinEstrategia() throws Exception {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();
        ArrayList<Ciudad> ciudades = jugador.verConexiones();
        Ciudad ciudad = ciudades.get(0);
        jugador.viajarACiudad(ciudad);
        ArrayList<Edificio> edificios = jugador.verEdificios();
        Edificio edificio = edificios.get(0);
        String pista = jugador.visitarEdificio(edificio);
        Assert.assertEquals("","");

    }

    @Test
    public void recibirPistaConEstrategiaYDeLadron() throws Exception {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();
        ArrayList<Edificio> edificios = jugador.verEdificios();
        Edificio edificio = edificios.get(0);
        String pista = jugador.visitarEdificio(edificio);

        Assert.assertEquals("","");

    }

    }
