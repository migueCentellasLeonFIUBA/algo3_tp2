package CasoDeUsoEntrega2;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CasoDeUsoUno {
    /*
        Detective sufre una herida de cuchillo.
        Detective duerme.
     */

/*
    @Test
    public void Test01DetectiveSufreHeridaCuchillo() throws Exception {
        Juego juegoActual = new Juego();
        Jugador jugadorActual = juegoActual.IdentificarJugador("Nico");
        juegoActual.crearCaso();
        Ciudad ciudadActual = jugadorActual.getCiudadActual();
        Ladron ladronActual = new Ladron();
        ciudadActual.setLadron(ladronActual);

        Banco bancoMock = Mockito.spy(Banco.class);
        when(bancoMock.visitarEdificio(any(), any())).thenReturn("Pista Banco");
        jugadorActual.visitarEdificio(bancoMock);

        int horasEsperadas = 165;
        assertEquals(jugadorActual.horasRestantes(), horasEsperadas);
    }

    @Test
    public void Test02DetectiveDuerme(){

    }
*/
}
