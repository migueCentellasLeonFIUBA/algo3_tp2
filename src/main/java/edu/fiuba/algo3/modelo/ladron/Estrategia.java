
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ciudades.CiudadEstrategia;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<String> ciudades;
    private Integer siguiente = 0;

    public Estrategia(ArrayList<String> listaCiudades) {
        ciudades=listaCiudades;
    }

    public void aplicarEstrategia() {
    }


}
