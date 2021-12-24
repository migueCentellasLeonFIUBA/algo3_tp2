package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public interface Valor {

    Estrategia crearEstrategia(Ciudad ciudad, Ciudades ciudades);
    String getRareza();

}
