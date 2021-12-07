package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.objetos.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;

public class JuegoTest{
    @Test
    public void algunosObjetoSeCargaConParametrosEsperados() throws Exception {

        Juego juego = new Juego();
        List<Objeto> obj = juego.getObjetos();
        Valor rareza = obj.get(0).getRareza();

        //Primer Objeto del archivo
        String nombre = "Huevo de 1000 años";

        assertEquals(nombre, obj.get(0).getNombre());
        assertThat(rareza).isInstanceOf(Comun.class);

        //Ultimo Objeto del archivo
        nombre = "Tocado del rey Watusi";
        rareza = obj.get(27).getRareza();
        assertEquals(nombre, obj.get(27).getNombre());
        assertThat(rareza).isInstanceOf(MuyValioso.class);

    }
}
