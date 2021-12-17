package CasoDeUsoEntrega2;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CasoDeUsoUnoTest {

    @Test
    public void Test01DetectiveSufreHeridaCuchillo() throws Exception {
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

        //CARGA DE OBJETOS
        Ciudad ciudad = ciudades.ObtenerCiudadRandom();
        Objeto objeto = objetos.ObtenerObjetoRandom();
        Ladron ladron = sospechosos.ObtenerLadronRandom();

        jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);

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
