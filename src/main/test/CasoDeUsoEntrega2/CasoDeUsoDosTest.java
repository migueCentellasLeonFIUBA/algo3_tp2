package CasoDeUsoEntrega2;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorCiudadConcreta;
import edu.fiuba.algo3.modelo.IBuilder.DirectorCiudad;
import edu.fiuba.algo3.modelo.ManejoArchivos.*;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUsoDosTest {

    @Test
    public void TestInvestigadorViajaDeMontrealAMexico() throws FileNotFoundException {

        Jugador jugador = new Jugador("Alexis", 10);

        //CARGA DE ARCHIVOS
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Ciudades ciudades = new Ciudades(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        Objetos objetos = new Objetos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));

        //CARGA DE OBJETOS
        Ciudad montreal = crearCiudad("Montreal");
        Ciudad mexico = crearCiudad("Mexico");
        Objeto objetoRandom = jugador.obtenerObjetoRandom(objetos);
        Ladron ladronRandom = sospechosos.ObtenerLadronRandom();

        jugador.empezarCaso(ladronRandom, objetoRandom, montreal, ciudades, sospechosos);
        jugador.viajarACiudad(mexico);

        //2 HORAS DE VIAJE APROX
        Integer timpoRestante = 166;
        assertEquals(timpoRestante, jugador.horasRestantes());
    }

    public Ciudad crearCiudad(String nombre) throws FileNotFoundException {
        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Fachada fachada = new Fachada(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
        ConstructorCiudadConcreta constructor = new ConstructorCiudadConcreta();
        DirectorCiudad director = new DirectorCiudad();
        director.setConstructorCiudad(constructor);

        director.construirCiudad(fachada, nombre);
        return director.getCiudad();
    }


}
