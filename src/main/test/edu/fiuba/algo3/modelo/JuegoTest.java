package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorJuegoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorJuego;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;

public class JuegoTest{

    @Test
    public void Test01PierdoElJuegoPorNoGenerarLaOrden() throws Exception {
        //----------------------------------------------------SetUp------------------------------------------------
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("rafael");
        juego.comenzarCaso();
//----------------------------------------------------Ciudad1 - Pekin----------------------------------------------
        ArrayList<Edificio> edificios = jugador.verEdificios();
        Edificio edificio1 = edificios.get(0);
        Edificio edificio2 = edificios.get(1);
        Edificio edificio3 = edificios.get(2);

        String pista1 = jugador.visitarEdificio(edificio1);
        String pista2 = jugador.visitarEdificio(edificio2);
        String pista3 = jugador.visitarEdificio(edificio3);

        Assert.assertTrue(pista1.contains("Mar Egeo"));
        Assert.assertTrue(pista2.contains("Euros"));
        Assert.assertTrue(pista3.contains("escudo espartano"));

        ArrayList<Ciudad> ciudades= jugador.verConexiones();

        Ciudad ciudad =  ciudades.get(1);//Seleccionar ciudad.

        jugador.viajarACiudad(ciudad);
//----------------------------------------------------Ciudad2 - Atenas -----------------------------------------------
        Assert.assertEquals("Atenas",ciudad.getNombre());
        edificios = jugador.verEdificios();

        edificio1 = edificios.get(0);
        edificio2 = edificios.get(1);
        edificio3 = edificios.get(2);

        pista1 = jugador.visitarEdificio(edificio1);
        pista2 = jugador.visitarEdificio(edificio2);
        pista3 = jugador.visitarEdificio(edificio3);

        Assert.assertTrue(pista1.contains("amarilla, verde y naranja"));
        Assert.assertTrue(pista2.contains("imperio britanico"));
        Assert.assertTrue(pista3.contains("rupias"));

        ciudades = jugador.verConexiones();

        ciudad =  ciudades.get(0);//Seleccionar ciudad.

        jugador.viajarACiudad(ciudad);

//----------------------------------------------------Ciudad3 - Colombo ------------------------------------------------
        Assert.assertEquals("Colombo",ciudad.getNombre());
        edificios = jugador.verEdificios();

        edificio1 = edificios.get(0);
        edificio2 = edificios.get(1);
        edificio3 = edificios.get(2);

        pista1 = jugador.visitarEdificio(edificio1);
        pista2 = jugador.visitarEdificio(edificio2);
        pista3 = jugador.visitarEdificio(edificio3);

        Assert.assertTrue(pista1.contains("Roja y blanca"));
        Assert.assertTrue(pista2.contains("Soles"));
        Assert.assertTrue(pista3.contains("Incas"));

        ciudades = jugador.verConexiones();

        ciudad =  ciudades.get(0);//Seleccionar ciudad.

        jugador.viajarACiudad(ciudad);

//----------------------------------------------------Ciudad4 - Lima ------------------------------------------------
        Assert.assertEquals("Lima",ciudad.getNombre());

        edificios = jugador.verEdificios();

        edificio1 = edificios.get(0);
        edificio2 = edificios.get(1);
        edificio3 = edificios.get(2);

        String accion1 = jugador.visitarEdificio(edificio1);
        String accion2 = jugador.visitarEdificio(edificio2);
        String accion3 = jugador.visitarEdificio(edificio3);
        ArrayList<String> conjuntoDeAcciones=new ArrayList<>();
        conjuntoDeAcciones.add(accion1);
        conjuntoDeAcciones.add(accion2);
        conjuntoDeAcciones.add(accion3);

        Assert.assertTrue(conjuntoDeAcciones.contains("Ladron atrapado  pero usted no tiene la orden cargada, perdió el juego."));
        Assert.assertTrue(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));
        Assert.assertTrue(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));

    }

    @Test
    public void PerderJuego() throws Exception {

        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();

        ArrayList<Ciudad> destinos = new ArrayList<>();

        //viajo hasta quedarme sin horas
        for (int i = 0; i < 168; i++) {
            destinos = jugador.obtenerSiguientesDestinos();
            jugador.viajarACiudad(destinos.get(0));
        }

        assert(jugador.terminarJuego());
    }

}
