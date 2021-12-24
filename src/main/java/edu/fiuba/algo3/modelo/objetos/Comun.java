package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Comun implements Valor {

    @Override
    public Estrategia crearEstrategia(Ciudad ciudad, Ciudades ciudades) {

        return (new Estrategia(4, ciudad, ciudades));
    }

    public String getRareza(){
        return "Comun";
    }
}