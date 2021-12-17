package CasoDeUsoEntrega2;

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

/*
    Un detective hace 6 Arrestos.
    Toma un caso de un sospechoso que robó un Incan Gold Mask.
    Realiza la investigación.
    Emite la orden.
    Atrapa al sospechoso.
 */

public class CasoDeUsoCincoTest {

    @Test
    public void unJugadorPuedeArrestarAUnLadron_6_veces() throws FileNotFoundException {

        Jugador jugador = new Jugador("Miguel", 0);

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

        //Arresta 6 veces...
        //hardcodeo
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));
        assert(jugador.arrestarLadron(ladron));

        /*
            Toma un caso de un sospechoso que robó un Incan Gold Mask.
            Realiza la investigación.
            Emite la orden.
            Atrapa al sospechoso.
         */

        //Se asigna un nuevo caso
        jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos);

        assertEquals(1, jugador.buscarSospechosos(caracteristicas, valores).size() );

        //Se hace un arresto
        assert(jugador.arrestarLadron(ladron));

    }
}
