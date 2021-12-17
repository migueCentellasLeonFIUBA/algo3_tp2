package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void unJugadorPuedeHacerUnArresto() throws FileNotFoundException {

        Jugador jugador = new Jugador("Miguel", 5);

        //CARGA DE ARCHIVOS
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Ciudades ciudades = new Ciudades(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        Objetos objetos = new Objetos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));

        //CARGA DE OBJETOS
        Ciudad ciudad = ciudades.ObtenerCiudadRandom();
        Objeto objeto = jugador.obtenerObjetoRandom(objetos);
        Ladron ladron = sospechosos.ObtenerLadronRandom();
        ciudad.setLadron(ladron);

        jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);

        //devuelve todos los sospechosos del archivo...
        assertEquals(2, jugador.buscarSospechosos().size());

        /*
        "Merey Laroc":{
            "Sexo": "Femenino",
            "Hobby" : "Tenis",
            "Cabello" : "Rojo",
            "Senia" : "Tatuaje",
            "Vehiculo" : "Deportivo"
          },
         */

        ArrayList<String> caracteristicas = new ArrayList<>();
        caracteristicas.add("Sexo");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");

        //por ahora solo hay 2 coincidencias, que es la cantidad actual de sospechosos femeninos del archivo...
        assertEquals(2, (jugador.buscarSospechosos(caracteristicas, valores)).size());

        caracteristicas.add("Hobby");
        valores.add("Tenis");

        caracteristicas.add("Cabello");
        valores.add("Rojo");

        caracteristicas.add("Senia");
        valores.add("Tatuaje");

        caracteristicas.add("Vehiculo");
        valores.add("Deportivo");
        //devuelve uno solo, que resutla ser el ladron...
        assertEquals(1, jugador.buscarSospechosos(caracteristicas, valores).size());

        //como queda un solo sospechoso, entonces puedo arrestarlo...
        assert (jugador.arrestarLadron(ladron));

    }
    @Test
    public void unJugadorPuedeArrestarAUnLadron_6_veces() throws FileNotFoundException {

        Jugador jugador = new Jugador("Miguel", 5);

        //CARGA DE ARCHIVOS
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Ciudades ciudades = new Ciudades(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        Objetos objetos = new Objetos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));

        //CARGA DE OBJETOS
        Ciudad ciudad = ciudades.ObtenerCiudadRandom();
        Objeto objeto = jugador.obtenerObjetoRandom(objetos);
        Ladron ladron = sospechosos.ObtenerLadronRandom();
        ciudad.setLadron(ladron);

        jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);

        ArrayList<String> caracteristicas = new ArrayList<>();
        caracteristicas.add("Sexo");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");

        caracteristicas.add("Hobby");
        valores.add("Tenis");

        caracteristicas.add("Cabello");
        valores.add("Rojo");

        caracteristicas.add("Senia");
        valores.add("Tatuaje");

        caracteristicas.add("Vehiculo");
        valores.add("Deportivo");
        //devuelve uno solo, que resutla ser el ladron...
        assertEquals(1, jugador.buscarSospechosos(caracteristicas, valores).size() );

        //como queda un solo sospechoso, entonces puedo arrestarlo...
        //hardcodeo
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));


    }
}
