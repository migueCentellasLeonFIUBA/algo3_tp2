package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class MuyValioso implements Valor{

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad) {
        return (new Estrategia(7, ciudad));
    }
}
