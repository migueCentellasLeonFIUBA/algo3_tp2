package CasosDeUso;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.PistaEconomica;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.RarezaComun;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUsoUno {

    @Test
    public void CasoUno() {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");

        assertEquals("Nico", jugador.getNombre());
        assertTrue(1==jugador.getArrestos());

        Caso nuevoCaso= Caso.crearCaso();
    }

    @Test
    public void CasoUnoBis() {

        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");
        assertEquals("Nico", jugador.getNombre());
        Objeto objeto = new Objeto();
        objeto.setRareza(new RarezaComun());

        Caso nuevoCaso= Caso.crearCaso();
        nuevoCaso.setObjeto(objeto);
        Ladron femenino = new Ladron();
        nuevoCaso.setLadron(femenino);

        assertThat(nuevoCaso.getObjetoRobado().getRareza()).isInstanceOf(RarezaComun.class);
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
