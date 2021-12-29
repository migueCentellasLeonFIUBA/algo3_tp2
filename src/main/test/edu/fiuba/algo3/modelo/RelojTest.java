package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Reloj;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelojTest {

    @Test
    public void TestElJugadorTiene168HorasParaResolverElCaso(){

        Reloj reloj = new Reloj();

        reloj.descontarhoras(111);
        assertEquals(false, reloj.tiempoTerminado());

        reloj.descontarhoras(1);
        assertEquals(true, reloj.tiempoTerminado());
    }

    @Test
    public void TestElJugadorDebeDormir8HsPorDia(){
        Integer diasRestantes;

        Reloj reloj = new Reloj();

        //SE DESCUENTAN 112 HORAS DE LAS 168, SIN EMBARGO EL JUGADOR SE PASA 56 HORAS DURMIENDO
        for(diasRestantes = 7; diasRestantes > 0; diasRestantes--){
            reloj.descontarhoras(16);
        }

        assertEquals(true, reloj.tiempoTerminado());

    }
}
