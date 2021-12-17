package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecuacesTest {

    @Test
    public void unSecuazNoAtacaAlJugador(){

        Secuaz sospechoso = new Secuaz("Merley");
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);

        sospechoso.atacarConArma(reloj);
        sospechoso.atacarConCuchillo(reloj);

        assertEquals(4, reloj.getHorasRestantes());
    }

    @Test
    public void unLadronAtacaConCuchilloDosVecesYDescuenta_3_Horas(){

        Ladron sospechoso = new Ladron();
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);

        sospechoso.atacarConCuchillo(reloj);
        sospechoso.atacarConCuchillo(reloj);

        assertEquals(1, reloj.getHorasRestantes());
    }

    @Test
    public void unLadronAtacaConArmaYDescuenta_4_Horas(){

        Ladron sospechoso = new Ladron();
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);

        sospechoso.atacarConArma(reloj);

        assertEquals(0, reloj.getHorasRestantes());
        assert(reloj.tiempoTerminado());
    }

}
