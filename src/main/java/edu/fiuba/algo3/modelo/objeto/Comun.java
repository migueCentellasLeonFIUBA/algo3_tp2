package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Comun implements Valor {

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad) {
        Estrategia estrategia = new Estrategia(4, ciudad);
        return (estrategia);
    }
}
