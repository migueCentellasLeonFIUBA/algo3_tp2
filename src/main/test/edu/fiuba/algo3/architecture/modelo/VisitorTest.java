package edu.fiuba.algo3.architecture.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.AeroPuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTest {
    @Test
    public void Test01DetectiveVisitaBancoYrecibeUnaPista() throws Exception {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Tomas");
        juego.crearCaso();
        String pista = jugador.visitarEdificio(new AeroPuerto());

        Assertions.assertEquals("AeroQuebec", pista);
    }
}
