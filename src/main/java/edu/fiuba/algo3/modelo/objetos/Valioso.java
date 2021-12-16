package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Valioso implements Valor{

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad, Ciudades ciudades) {
        return (new Estrategia(5, ciudad, ciudades));
    }
}