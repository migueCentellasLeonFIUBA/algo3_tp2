package CasosDeUso;

import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class CasoDeUsoDos {

    @Test
    public void casoDeUsoDos(){

        List<Edificio> listaEdificios;

        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");
        assertEquals("Nico",jugador.getNombre());


        juego.crearCaso();
        listaEdificios = jugador.mostrarEdificios();
        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(167, jugador.horasRestantes());

        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(165, jugador.horasRestantes());

        assertEquals("Pista Biblioteca", jugador.visitarEdificio(listaEdificios.get(2)));
        assertEquals(162, jugador.horasRestantes());

    }


}
