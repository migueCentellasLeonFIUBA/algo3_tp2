package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

public interface Edificio {

    String visitarEdificio(String ciudad, GradoPolicia grado);
    //void DamePista(); //debe devolver "Pista".
}
