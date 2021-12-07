package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Comun implements Valor {

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad) {

        return (Estrategia.crearEstrategia(4, ciudad));
    }
}