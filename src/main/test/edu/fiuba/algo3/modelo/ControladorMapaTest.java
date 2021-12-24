package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.ControladorMapa;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControladorMapaTest {

    //Test de integracion
    @Test
    public void sePuedeHacerUnViajeEntreUnaCiudadDelMapaYUnaDelCaso() throws Exception {

        Juego juego = new Juego();
        ControladorMapa controladorMapa;

        Jugador jugador = juego.IdentificarJugador("pablo");
        Mapa mapa = juego.cargarMapa();
        Ciudad origen = juego.crearCaso();
        //le paso una ciudad del caso al mapa, para que cargue sus conexiones.
        mapa.cargarCiudades(origen);

        controladorMapa = new ControladorMapa(mapa, jugador, juego);
        String destino = (mapa.getCiudadesDisponibles()).get(0);    //debo implementar las ciudades enlazadas.
        //String destino = mapa.getCiudadesDisponibles().get(2); //descomentar cuando se implmenten las conexiones.

        Integer horasRestantes = jugador.horasRestantes();
        controladorMapa.viajarACiudad(destino);

        //el jugador pudo viajar, entonces se le descontaron horas.
        //assert(horasRestantes < (jugador.horasRestantes()));

        //como no estan implmentadas las conexiones
        //viajar a la misma ciudad consume 1 hora...
        assertEquals(horasRestantes -1, (jugador.horasRestantes()));
    }
}
