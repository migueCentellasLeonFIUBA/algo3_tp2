package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.juego.Juego;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadesTest {

    @Test
    void Test01SeCarganLasCiudades() throws FileNotFoundException {
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Ciudades ciudades = new Ciudades(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        ArrayList<Ciudad> listaCiudades = ciudades.crearCiudades();

        assertEquals(8, listaCiudades.size());
    }

}
