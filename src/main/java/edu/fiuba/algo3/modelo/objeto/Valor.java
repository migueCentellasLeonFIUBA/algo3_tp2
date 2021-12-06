package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public interface Valor {

    Estrategia crearEstrategia(Ciudad ciudad);

}


