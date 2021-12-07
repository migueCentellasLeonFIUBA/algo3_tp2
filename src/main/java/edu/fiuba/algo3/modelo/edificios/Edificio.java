package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;

public interface Edificio {

    String visitarEdificio(String ciudad, GradoPolicia grado) throws FileNotFoundException;
    void DamePista(); //debe devolver "Pista".
}
