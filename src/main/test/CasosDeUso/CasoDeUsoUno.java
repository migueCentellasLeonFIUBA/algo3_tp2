package CasosDeUso;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUsoUno {

    @Test
    public void CasoUno() {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");

        assertEquals("Nico",jugador.getNombre());
        assertTrue(1==jugador.getArrestos());


    }

    @Test
    public void CasoUnoBis() throws Exception {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");
        assertEquals("Nico",jugador.getNombre());

        juego.crearCaso();
        jugador.visitarEdificio();

        /*nuevoCaso.setObjeto(new Objeto());
        Ladron femenino = new Ladron();
        nuevoCaso.setLadron(femenino);

        assertThat(nuevoCaso.getObjetoRobado()).isInstanceOf(Objeto.class);
        assertThat(nuevoCaso.getLadron()).isInstanceOf(Ladron.class);

        Ciudad ciudadMock = mock(Ciudad.class);
        when(ciudadMock.getNombre()).thenReturn("Montreal");

        jugador.comienzaEnCiudad(ciudadMock);

        assertEquals("Montreal",jugador.getCiudadActual().getNombre());
        assertEquals(1,jugador.getArrestos());

        Pista IPista = new PistaEconomica();
        when(ciudadMock.visitarEdificio(any(),any())).thenReturn(IPista);
        Pista pista =jugador.visitarEdificio();

        assertThat(pista).isInstanceOf(PistaEconomica.class);
        */

        /*

        so de uso 1
        Robaron el tesoro Nacional de Montreal.
        Sospechoso femenino.
        Detective novato comienza en Montreal.
        Vista un Banco:
        Se despliega una pista

         */
    }
}
