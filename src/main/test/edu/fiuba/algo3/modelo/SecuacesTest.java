package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaces;
import edu.fiuba.algo3.modelo.ladron.Secuaz;
import edu.fiuba.algo3.modelo.ladron.nullLadron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecuacesTest {

    @Test
    public void unSecuazNoAtacaAlJugador(){

        Secuaces ladron = new Secuaz("Martin");
        Jugador jugador = new Jugador("Nico", 0);

        ladron.atacar(jugador);

        assertEquals(168, jugador.horasRestantes());
    }

    @Test
    public void unLadronAtacaConCuchilloDosVecesYDescuenta_3_Horas(){

        Secuaces ladron = new Ladron();
        Jugador jugador = new Jugador("Nico", 0);

        ladron.atacar(jugador);
        ladron.atacar(jugador);

        assertEquals(165, jugador.horasRestantes());
    }

    @Test
    public void unLadronAtacaConArmaYDescuenta_4_Horas(){

        Secuaces ladron = new Ladron();
        Jugador jugador = new Jugador("Nico", 0);

        ladron.setPistola();

        ladron.atacar(jugador);

        assertEquals(164, jugador.horasRestantes());
    }

}
