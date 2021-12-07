package CasosDeUso;

import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.rangos.Novato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUsoUno {

    @Test
    public void CasoUno() throws Exception {
        List<Edificio> listaEdificios;

        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");
        assertEquals("Nico",jugador.getNombre());


        juego.crearCaso();
        listaEdificios = jugador.mostrarEdificios();
        assertEquals("Pista Banco", jugador.visitarEdificio(listaEdificios.get(1)));
        assertEquals(167, jugador.horasRestantes());

    }
}
