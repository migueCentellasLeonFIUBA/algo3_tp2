
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ciudades.Ciudad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Estrategia {

    private List<String> ciudades;
    private Integer siguiente = 0;

    public Estrategia(ArrayList<String> listaCiudades) {
        ciudades=listaCiudades;
    }

    public void aplicarEstrategia(Map<String, Ciudad> ciudades) {
        for(String ciudad: this.ciudades){
            //ciudades.put(ciudad,);
        }
    }


}
