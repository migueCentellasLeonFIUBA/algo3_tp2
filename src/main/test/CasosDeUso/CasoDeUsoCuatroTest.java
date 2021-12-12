package CasosDeUso;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUsoCuatroTest {

    /*
        Vista un Aeropuerto (3 veces):
        Se despliega una pista.
        Vista un Puerto (55 veces):
        Se despliega una pista.
     */

    @Test
    public void casoDeUsoCuatro() throws Exception {
/*
        List<Edificio> listaEdificios = new ArrayList<>();

        Jugador jugador = Jugador.crearJugador("Nico", 0);
        assertEquals("Nico",jugador.getNombre());
        assertEquals("Novato", jugador.getGrado());
        assertEquals(0, jugador.getArrestos());

        Ciudad ciudad = Ciudad.crear("Montreal");
        listaEdificios.add(new Puerto());
        listaEdificios.add(new Banco());
        listaEdificios.add(new AeroPuerto());
        ciudad.setEdificios(listaEdificios);

        Ladron ladron = Ladron.crear(new ArrayList<>());
        Objeto objeto= Objeto.crear("Tesoro Nacional De Montreal", "Comun");

        Caso caso = Caso.crearCaso(ladron, objeto, ciudad);

        jugador.empezarCaso(caso, ciudad);

        listaEdificios = jugador.mostrarEdificios();
        assertEquals("Pista Aeropuerto", jugador.visitarEdificio(listaEdificios.get(2)));
        assertEquals(167, jugador.horasRestantes());

        assertEquals("Pista Aeropuerto", jugador.visitarEdificio(listaEdificios.get(2)));
        assertEquals(165, jugador.horasRestantes());

        assertEquals("Pista Aeropuerto", jugador.visitarEdificio(listaEdificios.get(2)));
        assertEquals(162, jugador.horasRestantes());

        for(int i = 0; i < 55 ; i++){

            if(jugador.tieneCasoAsignado())
                assertEquals("Pista Puerto", jugador.visitarEdificio(listaEdificios.get(0)));
            else
                break;

        }
        assertEquals(false, jugador.tieneCasoAsignado());
        */
    }


}
