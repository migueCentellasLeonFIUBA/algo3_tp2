
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;

import java.util.List;

public class Estrategia {

    private List<CiudadNoEstrategia> ciudades;
    private Integer siguiente = 0;
/*
    public Estrategia(Integer cantCiudades, Ciudad ciudad, Ciudades ciudades) {
        this.ciudades = new ArrayList<>();
        this.ciudades.add(ciudad);
        this.asignarEstrategia(cantCiudades, ciudad);
    }
*/
    public CiudadNoEstrategia getProximaCiudad() {
        CiudadNoEstrategia siguienteCiudad = ciudades.get(siguiente);
        siguiente += 1;
        return siguienteCiudad;
    }

    private void asignarEstrategia(Integer cantCiudades, CiudadNoEstrategia ciudadOrigen){
    }
}
