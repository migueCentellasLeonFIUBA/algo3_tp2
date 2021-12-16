package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SospechososTest {

    @Test
    public void losDatosDeUnLadronEncuentranAUnSospechoso(){
        String leido = "{\"Merey Laroc\":{ \"Sexo\": \"Femenino\",\"Hobby\" : \"Escalar Montanias\", \"Cabello\" : \"Marron\", \"Senia\" : \"Joyas\", \"Vehiculo\" : \"Limosina\" }}";

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");
        valores.add("Escalar Montanias");

        Sospechosos sospechosos = new Sospechosos(leido);
        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores);

        assert(obtenidos.get(0).equals("Merey Laroc"));
    }

    @Test
    public void losDatosDeUnLadronEncuentranSospechosos() throws FileNotFoundException {

        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();

        leido = gestorArchivos.leerTextoCompleto(ruta);

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");

        assert(leido.contains("Merey Laroc"));
        assert(leido.contains("Carmen"));

        //System.out.println(leido);
        Sospechosos sospechosos = new Sospechosos(leido);

        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores);

        assert(obtenidos.get(0).equals("Merey Laroc"));
        assert(obtenidos.get(1).equals("Carmen"));
    }

}
