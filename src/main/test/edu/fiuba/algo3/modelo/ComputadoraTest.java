package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorJuegoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorJuego;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.NoOrden;
import edu.fiuba.algo3.modelo.jugador.Orden;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ComputadoraTest {

    @Test
    public void TestComputadoraSinParametrosNoDevuelveNingunSospechoso() throws Exception {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();

        ArrayList<String> caracterisitcasABuscar = new ArrayList<>();
        ArrayList<ISospechable> listaSospechosos = jugador.buscarSospechosos(caracterisitcasABuscar);
        Assert.assertEquals(2, listaSospechosos.size());
    }

    @Test
    public void TestSiSeTienenTodosLosParametrosSeDevuelveUnSospechoso() throws Exception {

        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();
        ArrayList<String> caracterisitcasABuscar = new ArrayList<>();

         /*
         "Merey Laroc":{
            "Sexo": "Femenino",
            "Hobby" : "Tenis",
            "Cabello" : "Rojo",
            "Senia" : "Tatuaje",
            "Vehiculo" : "Deportivo"
          },
         */

        caracterisitcasABuscar.add("Femenino");
        caracterisitcasABuscar.add("Tenis");
        caracterisitcasABuscar.add("Rojo");
        caracterisitcasABuscar.add("Tatuaje");
        caracterisitcasABuscar.add("Deportivo");

        ArrayList<ISospechable> listaSospechosos = jugador.buscarSospechosos(caracterisitcasABuscar);
        Assert.assertEquals(1, listaSospechosos.size());

    }

    @Test
    public void TestSiSeTienenParametrosEnComunDevuelveLosSospechososQueCumplen() throws Exception {

        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();
        ArrayList<String> caracterisitcasABuscar = new ArrayList<>();

        //"Merey Laroc":["Femenino","Tenis","Rojo","Tatuaje","Deportivo"],
        //"Carmen Sandiego":["Femenino","Croquet","Negro","Joyas","Limusina"]

        caracterisitcasABuscar.add("Femenino");

        ArrayList<ISospechable> listaSospechosos = jugador.buscarSospechosos(caracterisitcasABuscar);
        Assert.assertEquals(2, listaSospechosos.size());
    }

    @Test
    public void TestComputadoraConParametrosErroneosNoDevuelveSospechosos() throws Exception {

        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();
        ArrayList<String> caracterisitcasABuscar = new ArrayList<>();

        caracterisitcasABuscar.add("Masculino");

        ArrayList<ISospechable> listaSospechosos = jugador.buscarSospechosos(caracterisitcasABuscar);
        Assert.assertEquals(0, listaSospechosos.size());
    }

    @Test
    public void TestComputadoraConAlgunosParametrosFiltraAlgunosSosepchosos() throws Exception{
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();
        ArrayList<String> caracterisitcasABuscar = new ArrayList<>();

        jugador.siguienteSexo();

        jugador.siguienteCabello();
        jugador.siguienteCabello();


        ArrayList<ISospechable> listaSospechosos = jugador.buscarSospechosos();
        Assert.assertEquals(1, listaSospechosos.size());
    }




}


