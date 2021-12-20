package edu.fiuba.algo3.modelo;

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

    /*
        Secuaz sospechoso = new Secuaz("Merley");
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);

        sospechoso.atacarConArma(reloj);
        sospechoso.atacarConCuchillo(reloj);

     */

        Secuaces ladron = new nullLadron();
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);
        ladron.atacar(reloj);

        assertEquals(4, reloj.getHorasRestantes());
    }

    @Test
    public void unLadronAtacaConCuchilloDosVecesYDescuenta_3_Horas(){

        Secuaces ladron = new Ladron();
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);

        ladron.atacar(reloj);
        ladron.atacar(reloj);

        assertEquals(1, reloj.getHorasRestantes());
    }

    @Test
    public void unLadronAtacaConArmaYDescuenta_4_Horas(){

        Secuaces ladron = new Ladron();
        Reloj reloj = new Reloj();

        reloj.setHorasRestantes(4);
        ladron.setPistola();

        ladron.atacar(reloj);

        assertEquals(0, reloj.getHorasRestantes());
        assert(reloj.tiempoTerminado());
    }

}
