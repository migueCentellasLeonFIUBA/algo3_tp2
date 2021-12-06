package CasosDeUso;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class CasoDeUso5 {

    @Test
    public void jugadorEsApunialado(){

        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");

        Caso nuevoCaso= Caso.crearCaso();
        nuevoCaso.setObjeto(new Objeto());
        Ladron femenino = new Ladron();
        nuevoCaso.setLadron(femenino);

        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.setLadron(femenino);

        jugador.comienzaEnCiudad(ciudad);
        jugador.visitarEdificio();

        int horasEsperadas = 150;
        assertEquals(horasEsperadas, jugador.horasRestantes());

    }

    @Test
    public void jugadorDuerme(){

        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");

        jugador.dormir();

        int horasEsperadas = 144;
        assertEquals(horasEsperadas, jugador.horasRestantes());

    }

}
