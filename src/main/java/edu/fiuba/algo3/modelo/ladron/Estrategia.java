
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesRandom;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private CiudadesRandom ciudadesRandom;
    private Integer siguiente = 0;

    public Estrategia(Integer cantCiudades, Ciudad ciudad, Ciudades ciudades) {
        this.ciudades = new ArrayList<>();
        this.ciudades.add(ciudad);
        this.ciudadesRandom = new CiudadesRandom(ciudades.crearCiudades());
        this.asignarEstrategia(cantCiudades, ciudad);
    }

    public Ciudad getProximaCiudad() {
        Ciudad siguienteCiudad = ciudades.get(siguiente);
        siguiente += 1;
        return siguienteCiudad;
    }

    private void asignarEstrategia(Integer cantCiudades, Ciudad ciudadOrigen){
        this.ciudades = ciudadesRandom.getCiudadesRandom(ciudadOrigen, cantCiudades);
    }
}
