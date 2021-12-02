package CasosDeUso;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CasoDeUsoUno {

    @Test
    public void CasoUno() {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Nico");

        Assert.assertEquals("Nico",jugador.getNombre());
        Assert.assertTrue(1==jugador.getArrestos());

        Caso nuevoCaso= Caso.crearCaso();

    }
}
