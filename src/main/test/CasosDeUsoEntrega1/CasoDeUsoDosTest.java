package CasosDeUsoEntrega1;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasoDeUsoDosTest {

    /*
        Detective novato comienza en Montreal.
        Vista un Banco (nuevamente):
        Se despliega una pista
        Vista una Biblioteca:
        Se despliega una pista.
     */

    @Test
    public void casoDeUsoDos() throws Exception {


        List<Edificio> listaEdificios = new ArrayList<>();

/*
        Jugador jugador = Jugador.crearJugador("Nico", 0);
        assertEquals("Nico",jugador.getNombre());
        assertEquals("Novato", jugador.getGrado());
        assertEquals(0, jugador.getArrestos());

        Ciudad ciudad = Ciudad.crear("Montreal");
        listaEdificios.add(new Biblioteca());
        listaEdificios.add(new Banco());
        listaEdificios.add(new AeroPuerto());
        ciudad.setEdificios(listaEdificios);

        Ladron ladron = Ladron.crear(new ArrayList<>());
        Objeto objeto= Objeto.crear("Tesoro Nacional De Montreal", "Comun");

        Caso caso = Caso.crearCaso(ladron, objeto, ciudad);

        jugador.empezarCaso(caso, ciudad);
        listaEdificios = jugador.mostrarEdificios();
        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(167, jugador.horasRestantes());

        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(165, jugador.horasRestantes());

        assertEquals("Pista Biblioteca", jugador.visitarEdificio(listaEdificios.get(0)));
        assertEquals(162, jugador.horasRestantes());
        /*
 */
    }

}

