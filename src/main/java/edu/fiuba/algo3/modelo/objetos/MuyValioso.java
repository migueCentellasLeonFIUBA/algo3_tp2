package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesMapa;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class MuyValioso implements Valor{

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad, CiudadesMapa ciudades) {

        return (new Estrategia(7, ciudad, ciudades));
    }
}