package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class MuyValioso implements Valor{

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad) {

        return (Estrategia.crearEstrategia(7, ciudad));
    }
}