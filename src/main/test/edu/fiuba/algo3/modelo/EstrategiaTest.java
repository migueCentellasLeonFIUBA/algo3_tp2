package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesMapa;
import edu.fiuba.algo3.modelo.ciudades.Ruta;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstrategiaTest {

    /*
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
     */

    @Test
    public void unaEstrategiaDevuelveLaRutaEsperada(){

        Ruta ruta = new Ruta();
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setNombre("Mexico");
        Ciudad ciudad2 = new Ciudad();
        ciudad2.setNombre("Montreal");
        Ciudad ciudad3 = new Ciudad();
        ciudad3.setNombre("Kigali");
        Ciudad ciudad4 = new Ciudad();
        ciudad4.setNombre("Bagdad");

        ruta.setCiudadEnRuta(ciudad1);
        ruta.setCiudadEnRuta(ciudad2);
        ruta.setCiudadEnRuta(ciudad3);
        ruta.setCiudadEnRuta(ciudad4);

        Estrategia estrategia = new Estrategia(ruta);

        assertEquals(ciudad1, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad2);
        assertEquals(ciudad2, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad3);
        assertEquals(ciudad3, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad4);
        assertEquals(ciudad4, estrategia.getCiudadActual());
    }

    @Test
    public void viajarAUnaCiudadFueraDeLaRutaNoAvanzaEnLaRuta(){

        Ruta ruta = new Ruta();
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setNombre("Mexico");
        Ciudad ciudad2 = new Ciudad();
        ciudad2.setNombre("Montreal");
        Ciudad ciudad3 = new Ciudad();
        ciudad3.setNombre("Kigali");
        Ciudad ciudad4 = new Ciudad();
        ciudad4.setNombre("Bagdad");
        Ciudad ciudad5 = new Ciudad();
        ciudad5.setNombre("Londres");

        ruta.setCiudadEnRuta(ciudad1);
        ruta.setCiudadEnRuta(ciudad2);
        ruta.setCiudadEnRuta(ciudad3);
        ruta.setCiudadEnRuta(ciudad4);

        Estrategia estrategia = new Estrategia(ruta);

        assertEquals(ciudad1, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad2);
        assertEquals(ciudad2, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad3);
        assertEquals(ciudad3, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad5);
        assertEquals(ciudad3, estrategia.getCiudadActual());
    }

    @Test
    public void cuandoNoQuedanMasCiudadesEnLaRutaSiempreSeDevuelveLaUltimaDeLaRuta(){

        Ruta ruta = new Ruta();
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setNombre("Mexico");
        Ciudad ciudad2 = new Ciudad();
        ciudad2.setNombre("Montreal");
        Ciudad ciudad3 = new Ciudad();
        ciudad3.setNombre("Kigali");

        ruta.setCiudadEnRuta(ciudad1);
        ruta.setCiudadEnRuta(ciudad2);
        ruta.setCiudadEnRuta(ciudad3);

        Estrategia estrategia = new Estrategia(ruta);

        assertEquals(ciudad1, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad2);
        assertEquals(ciudad2, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad3);
        assertEquals(ciudad3, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad3);
        assertEquals(ciudad3, estrategia.getCiudadActual());

        ruta.viajarASiguienteCiudad(ciudad3);
        assertEquals(ciudad3, estrategia.getCiudadActual());
    }
}