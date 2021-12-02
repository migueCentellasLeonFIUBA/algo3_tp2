package CasosDeUso;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class CasoDeUsoUno {

    @Test
    public void CasoUno() {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("pepito");
    }
}
