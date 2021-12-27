package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.juego.Juego;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;

public class JuegoTest{

    @Test
    public void TestJuegoCargaCorrectamenteLosArchivos() {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        Juego juego = new Juego(fachada);
        Assert.assertEquals("","");
    }

    @Test
    public void TestJuegoCreaCasoCreaCorrectamente() throws Exception {

    }

}
