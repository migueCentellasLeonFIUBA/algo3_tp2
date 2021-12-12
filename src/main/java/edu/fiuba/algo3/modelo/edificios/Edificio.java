package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import java.io.FileNotFoundException;

public interface Edificio {

     String getNombre();

    String visitarEdificio(Pistas pistas) throws FileNotFoundException;

    String visitarEdificio(String proximaCiudad, GradoPolicia grado);
}
