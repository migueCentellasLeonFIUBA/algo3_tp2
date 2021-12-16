package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.*;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;

public class JuegoTest{

    @Test
    public void TestJuegoCargaCorrectamenteLosArchivos() throws Exception {

        Juego juego = new Juego();
    }

    @Test
    public void TestJuegoCreaCasoCreaCorrectamente() throws Exception {

        Juego juego = new Juego();
        juego.IdentificarJugador("Nico");
        juego.crearCaso();
    }

    /*
    @Test
    public void ObjetoSeCargaConParametrosEsperados() throws Exception {

        Juego juego = new Juego();
        List<Objeto> obj = juego.getObjetos();
        Valor rareza = obj.get(0).getRareza();

        //Primer Objeto del archivo
        String nombre = "Huevo de 1000 años";

        assertEquals(nombre, obj.get(0).getNombre());
        assertThat(rareza).isInstanceOf(Comun.class);

        //Ultimo Objeto del archivo
        nombre = "Tocado del rey Watusi";
        rareza = obj.get(27).getRareza();
        assertEquals(nombre, obj.get(27).getNombre());
        assertThat(rareza).isInstanceOf(MuyValioso.class);

    }

    public void jugadoresSeCargaConParametrosEsperados() throws Exception {

        Juego juego = new Juego();
        List<Jugador> jugadores = juego.getJugadores();
        Jugador jugador = jugadores.get(0);


        String nombre = "Huevo de 1000 años";

    }

        public void ladronesSeCargaConParametrosEsperados() throws Exception {

            Juego juego = new Juego();
            List<Ladron> ladrones = juego.getLadrones();
            Ladron ladron = ladrones.get(0);


            assertEquals(true, ladron.compararSexo("Femenino"));
            assertEquals(true, ladron.compararNombre("Merey Laroc"));
            assertEquals(true, ladron.compararHobby("Escalar Montañas"));
            assertEquals(true, ladron.compararCabello("Marron"));
            assertEquals(true, ladron.compararSenia("Joyas"));
            assertEquals(true, ladron.compararVehiculo("Limusina"));


        }

    public void ciudadSeCargaConParametrosEsperados() throws Exception {

        Juego juego = new Juego();
        List<Ciudad> ciudades = juego.getCiudades();
        Ciudad ciudad = ciudades.get(0);

        assertEquals("Montreal", ciudad.getNombre());
        //REFACTOR: FALTA TESTEAR LA INICIALIZACION DE COORDENADAS

    }

    public void jugadorIniciaUnCasoYVisitaEdificio() throws FileNotFoundException {

        Juego juego = null;
        try {
            juego = new Juego();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Jugador jugador = juego.IdentificarJugador("Alexis");

        try {
            juego.crearCaso();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Edificio> listaEdificios = jugador.mostrarEdificios();
        String pista = (jugador.visitarEdificio(listaEdificios.get(0)));

        assertEquals(true, pista.getClass().equals(String.class));
    }

     */
}
