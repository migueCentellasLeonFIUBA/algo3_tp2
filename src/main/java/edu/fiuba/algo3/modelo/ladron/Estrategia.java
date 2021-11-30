package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ciudad.Ciudad;

import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private Integer siguiente =0;

    public Ciudad getProximaCiudad() {
        siguiente += 1;
        return ciudades.get(siguiente);
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades.addAll(ciudades);
    }
    
}
