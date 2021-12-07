
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ciudades.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private Integer siguiente =0;

    private Estrategia(int cantCiudades, Ciudad ciudad) {
        ciudades = new ArrayList<>();
        ciudades.add(ciudad);
    }

    public static Estrategia crearEstrategia(int cantCiudades, Ciudad ciudad){
        return new Estrategia(cantCiudades, ciudad);
    }

    public Ciudad getProximaCiudad() {
        siguiente += 1;
        return ciudades.get(siguiente);
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades.addAll(ciudades);
    }

}
