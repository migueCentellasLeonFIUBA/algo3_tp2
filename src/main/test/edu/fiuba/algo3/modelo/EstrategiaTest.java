package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesMapa;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstrategiaTest {

    @Test
    public void seAsignaUnaEstrategia() {

        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json";

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Ciudades ciudadesCargadas = null;
        try {
            ciudadesCargadas = new Ciudades(gestorDeArchivos.leerTextoCompleto(ruta));
        } catch (FileNotFoundException e) {
        }

        ArrayList<Ciudad> listaCiudades = ciudadesCargadas.crearCiudades();

        CiudadesMapa ciudades = new CiudadesMapa(ciudadesCargadas.crearCiudades());
        assertEquals(8, listaCiudades.size());

        Estrategia estrategia = new Estrategia(4, listaCiudades.get(0),ciudades);
        ArrayList<Ciudad> ciudadesRandom = new ArrayList<>();

        for (int i = 0; i < 4 ; i++) {
            ciudadesRandom.add(estrategia.getProximaCiudad());
        }
        assertEquals(4, ciudadesRandom.size());
    }
}