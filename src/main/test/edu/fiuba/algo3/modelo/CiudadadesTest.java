package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudades.CiudadesRandom;
import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadadesTest{

    @Test
    public void seCarganAlgunasCiudades() throws FileNotFoundException {

        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json";

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Ciudades ciudadesCargadas = new Ciudades(gestorDeArchivos.leerTextoCompleto(ruta));
        ArrayList<Ciudad> listaCiudades = ciudadesCargadas.crearCiudades();

        assertEquals(8, listaCiudades.size());

        CiudadesRandom ciudades = new CiudadesRandom(listaCiudades);
        ArrayList<Ciudad> ciudadesRandom = ciudades.getCiudadesRandom(listaCiudades.get(0), 4);

        assertEquals(4, ciudadesRandom.size());
    }
}
