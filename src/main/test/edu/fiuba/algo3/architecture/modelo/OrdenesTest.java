package edu.fiuba.algo3.architecture.modelo;

import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaz;
import edu.fiuba.algo3.modelo.orden.OrdenDeArresto;
import edu.fiuba.algo3.modelo.orden.OrdenSinJurisdiccion;
import edu.fiuba.algo3.modelo.orden.Ordenes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class OrdenesTest {

    @Test
    public void noSePuedeArrestarAlLadronConUnaOrdenSinJurisdiccion(){

        Ladron ladron = new Ladron();
        OrdenSinJurisdiccion orden = new OrdenSinJurisdiccion();

        Assertions.assertNotEquals(true, orden.arrestarLadron(ladron));
    }

    @Test
    public void sePuedeArrestarAlLadronConUnaOrdenDeArresto(){

        Ladron ladron = new Ladron();
        OrdenDeArresto orden = new OrdenDeArresto();

        assert(orden.arrestarLadron(ladron));
    }

    @Test
    public void noSePuedeArrestarAUnSospechosoConUnaOrdenDeArresto(){

        Secuaz ladron = new Secuaz("Juan");
        OrdenDeArresto orden = new OrdenDeArresto();

        Assertions.assertNotEquals(true, orden.arrestarLadron(ladron));
    }

    @Test
    public void emitirUnaOrdenDeArrestoConUnaOrdenSinJurisdicionDevuelveUnaOrdenDeArrestoCuandoQuedaUnLadronComoSospechoso(){

        Ladron ladron = new Ladron();
        OrdenSinJurisdiccion ordenFalsa = new OrdenSinJurisdiccion();

        Assertions.assertNotEquals(true, ordenFalsa.arrestarLadron(ladron));

        Ordenes orden = ordenFalsa.emitirOrden(ladron);

        assert(orden.arrestarLadron(ladron));
    }

    @Test
    public void emitirUnaOrdenDeArrestoDesdeUnaOrdenDeArrestoDevuelveLaMismaOrdenDeArresto(){

        Ladron ladron = new Ladron();
        Ordenes orden = new OrdenDeArresto();

        assert(orden.arrestarLadron(ladron));

        orden = orden.emitirOrden(ladron);
        assert(orden.arrestarLadron(ladron));
    }

}
