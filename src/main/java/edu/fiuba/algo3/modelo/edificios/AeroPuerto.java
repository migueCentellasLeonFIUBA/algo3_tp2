package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.Ifarcade.Pistas;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;

public class AeroPuerto implements Edificio {

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public String visitarEdificio(Pistas pistas) throws FileNotFoundException {
        return null;
    }

    @Override
    public String visitarEdificio(String ciudad, GradoPolicia grado) {

        return "Pista Aeropuerto"; //REFACTOR NECESARIO - SE DEBE COMUNICAR CON LA FACHADA DE JSON
    }
    
}
