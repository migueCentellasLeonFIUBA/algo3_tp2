package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Ifarcade.Pistas;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;

public class Bolsa implements Edificio {
    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public String visitarEdificio(Pistas pistas) throws FileNotFoundException {
        return null;
    }

    @Override
    public String visitarEdificio(String proximaCiudad, GradoPolicia grado) {

        return "Pista Bolsa"; //REFACTOR NECESARIO - SE DEBE COMUNICAR CON LA FACHADA DE JSON
    }

}
