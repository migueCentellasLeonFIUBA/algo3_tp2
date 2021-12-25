package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadEstrategia;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadadesTest{

    @Test
    public void seCarganAlgunasCiudades() throws FileNotFoundException {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        Map<String, Ciudad> ciudades =  fachada.cargarCiudades();
    }

    @Test
    public void ssss() throws FileNotFoundException {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);

        //ArrayList<CiudadEstrategia> ciudades =  fachada.cargarCiudades();



    }
}
