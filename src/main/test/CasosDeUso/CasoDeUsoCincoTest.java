package CasosDeUso;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.AeroPuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUsoCincoTest {

    @Test
    public void casoDeUsoCinco() throws Exception {


        List<Edificio> listaEdificios = new ArrayList<>();


        Jugador jugador = Jugador.crearJugador("Nico", 6);
        assertEquals("Nico",jugador.getNombre());

        Ladron ladron = Ladron.crear(new ArrayList<>());
        Objeto objeto= Objeto.crear("Tesoro Nacional De Montreal", "Comun");

        Ciudad ciudad = Ciudad.crear("Montreal");
        listaEdificios.add(new Biblioteca());
        listaEdificios.add(new Banco());
        listaEdificios.add(new AeroPuerto());
        ciudad.setEdificios(listaEdificios);
        ciudad.setLadron(ladron);

        Caso caso = Caso.crearCaso(ladron, objeto, ciudad);

        jugador.empezarCaso(caso, ciudad);
        //juego.crearCaso();
        listaEdificios = jugador.mostrarEdificios();


        //VISITA DE 1H Y ATAQUE DE 2H
        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(165, jugador.horasRestantes());

        //VISITA DE 2H Y ATAQUE DE 1H
        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(162, jugador.horasRestantes());

        //VIISTA DE 3H Y ATAQUE DE 1H
        assertEquals("Pista Biblioteca", jugador.visitarEdificio(listaEdificios.get(0)));
        assertEquals(158, jugador.horasRestantes());

        //VIISTA DE 3H Y ATAQUE DE 1H
        assertEquals("Pista Biblioteca", jugador.visitarEdificio(listaEdificios.get(0)));
        assertEquals(154, jugador.horasRestantes());

        //VIISTA DE 3H Y ATAQUE DE 1H MAS DORMIR 8H
        assertEquals("Pista Biblioteca", jugador.visitarEdificio(listaEdificios.get(0)));
        assertEquals(142, jugador.horasRestantes());
    }

}
