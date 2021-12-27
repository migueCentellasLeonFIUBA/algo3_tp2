package CasoDeUsoEntrega2;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.orden.OrdenSinJurisdiccion;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
    Intentas atrapar al sospechoso sin la orden de arresto emitida. (Unitario)
 */
public class CasoDeUsoCuatroTest {

    @Test
    public void noSePuedeArrestarAlLadronConUnaOrdenSinJurisdiccion(){

        Ladron ladron = new Ladron();
        OrdenSinJurisdiccion orden = new OrdenSinJurisdiccion();

        assertNotEquals(true, orden.arrestarLadron(ladron));
    }

    @Test
    public void elJugadorIntentaArrestarAlLadronSinUnaOrdenYFalla() throws FileNotFoundException {

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

        assertNotEquals(true, jugador.arrestarLadron(ladron));
    }

}
