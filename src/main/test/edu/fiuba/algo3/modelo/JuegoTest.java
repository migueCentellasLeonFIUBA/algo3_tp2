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
    public void GanarJuego() throws Exception {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();

        ArrayList<Edificio> edificios1 = jugador.verEdificios();
        Edificio edificio1 = edificios1.get(0);
        Edificio edificio2 = edificios1.get(1);
        Edificio edificio3 = edificios1.get(2);

        String pista1 = jugador.visitarEdificio(edificio1);
        String pista2 = jugador.visitarEdificio(edificio2);
        String pista3 = jugador.visitarEdificio(edificio3);

        ArrayList<Ciudad> ciudades= jugador.verConexiones();

        Ciudad ciudad1 =  ciudades.get(1);

        jugador.viajarACiudad(ciudad1);

        ArrayList<Edificio> edificios2 = jugador.verEdificios();
        edificio1 = edificios2.get(0);
        edificio2 = edificios2.get(1);
        edificio3 = edificios2.get(2);

        pista1 = jugador.visitarEdificio(edificio1);
        pista2 = jugador.visitarEdificio(edificio2);
        pista3 = jugador.visitarEdificio(edificio3);




        Assert.assertEquals("","");

    }

    @Test
    public void PerderJuego() throws Exception {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();

        juego.IdentificarJugador("Lucio");
        Assert.assertEquals("","");
        juego.comenzarCaso();
        Assert.assertEquals("","");

    }

}
