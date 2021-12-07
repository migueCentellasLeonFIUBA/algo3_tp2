
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ciudades.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private Integer siguiente = 0;

    private Estrategia(int cantCiudades, Ciudad ciudad) {
        ciudades = new ArrayList<>();
        ciudades.add(ciudad);
        //this.asignarEstrategia - SE ASIGNARÍA UNA ESTRATEGIA AL AZAR CON LA CANTIDAD DE CIUDADAS QUE SE PASÓ POR PARAMETRO
    }

    public static Estrategia crearEstrategia(int cantCiudades, Ciudad ciudad){
        return new Estrategia(cantCiudades, ciudad);
    }

    public Ciudad getProximaCiudad() {
        siguiente += 1;
        return ciudades.get(siguiente);
    }

}
