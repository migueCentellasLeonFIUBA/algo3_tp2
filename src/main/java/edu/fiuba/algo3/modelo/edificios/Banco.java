package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import java.io.FileNotFoundException;

public class Banco implements Edificio {

    @Override
    public String visitarEdificio(String proximaCiudad, GradoPolicia grado) throws FileNotFoundException {

        return "Pista Banco";//REFACTOR NECESARIO - SE DEBE COMUNICAR CON LA FACHADA DE JSON
    }
}
