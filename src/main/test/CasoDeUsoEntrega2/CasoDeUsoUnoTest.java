package CasoDeUsoEntrega2;

import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Ruta;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CasoDeUsoUnoTest {

    @Test
    public void Test01DetectiveSufreHeridaCuchillo() throws Exception {
        Juego juego = new Juego();
        Jugador jugador = juego.IdentificarJugador("Miguel");//MIGUEL TIENE 5 ARRESTOS


        //CARGA DE ARCHIVOS
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Ciudades ciudades = new Ciudades(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        Objetos objetos = new Objetos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
        Pistas pistas = new Pistas(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json"));


        //CARGA DE OBJETOS
        jugador.cargarPistas(pistas);
        //Ciudad ciudad = ciudades.ObtenerCiudadRandom();
        Objeto objeto = jugador.obtenerObjetoRandom(objetos);
        Ladron ladron = sospechosos.ObtenerLadronRandom();


        //jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);

        //carga de ruta:
        Ruta ruta = new Ruta();
        ArrayList<Ciudad> ciudadesLeidas = ciudades.crearCiudades();

        ruta.setCiudadEnRuta(ciudadesLeidas.get(0));
        ruta.setCiudadEnRuta(ciudadesLeidas.get(1));
        ruta.setCiudadEnRuta(ciudadesLeidas.get(2));
        ruta.setCiudadEnRuta(ciudadesLeidas.get(3));

        Ciudad ciudad = ciudadesLeidas.get(0);
        ciudad.setLadron(ladron);

        //jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);
        jugador.empezarCaso(ladron, objeto, ciudad, sospechosos, ruta);
        jugador.visitarEdificio(new Banco());

        //1 HORA POR ENTRAR AL EDIFICIO Y DOS POR EL ATAQUE CON CUCHILLO
        Integer horasEsperadas = 165;
        assertEquals(horasEsperadas, jugador.horasRestantes());
    }

    @Test
    public void Test02DetectiveDuerme() throws FileNotFoundException {
        Jugador jugador = new Jugador("Alexis", 5);

        //CARGA DE ARCHIVOS
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Ciudades ciudades = new Ciudades(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        Objetos objetos = new Objetos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
        Pistas pistas = new Pistas(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json"));

        //CARGA DE OBJETOS
        Ciudad ciudad = ciudades.ObtenerCiudadRandom();
        Objeto objeto = objetos.ObtenerObjetoRandom();
        Ladron ladron = sospechosos.ObtenerLadronRandom();
        jugador.cargarPistas(pistas);

        //jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);

        //carga de ruta:
        Ruta ruta = new Ruta();
        ArrayList<Ciudad> ciudadesLeidas = ciudades.crearCiudades();

        ruta.setCiudadEnRuta(ciudadesLeidas.get(0));
        ruta.setCiudadEnRuta(ciudadesLeidas.get(1));
        ruta.setCiudadEnRuta(ciudadesLeidas.get(2));
        ruta.setCiudadEnRuta(ciudadesLeidas.get(3));

        //jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);
        jugador.empezarCaso(ladron, objeto, ciudad, sospechosos, ruta);

        //15 HORAS POR ENTRAR AL EDIFICIO 6 VECES
        Integer visitasAlEdificio;
        for(visitasAlEdificio = 6; visitasAlEdificio > 0; visitasAlEdificio--){
            jugador.visitarEdificio(new Banco());
        }
        Integer horasEsperadas = 153;
        assertEquals(horasEsperadas, jugador.horasRestantes());

        //3 HORAS POR VISITAR EL EDIFICIO + 8 POR DORMIR
        jugador.visitarEdificio(new Banco());

        horasEsperadas = 142;
        assertEquals(horasEsperadas, jugador.horasRestantes());
    }

}
