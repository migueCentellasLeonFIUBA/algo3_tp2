
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private Integer siguiente = 0;

    public Estrategia(Integer cantCiudades, Ciudad ciudad, Ciudades ciudades) {
        this.ciudades = new ArrayList<>();
        this.ciudades.add(ciudad);
        this.asignarEstrategia(cantCiudades, ciudades);
    }

    public Ciudad getProximaCiudad() {
        siguiente += 1;
        return ciudades.get(siguiente);
    }

    private void asignarEstrategia(Integer cantCiudades, Ciudades ciudades){
/*        Integer largoEstrategia;
        Ciudad ciudad;
        for(largoEstrategia = cantCiudades; largoEstrategia > 0; largoEstrategia--){
            ciudad = ciudades.ObtenerCiudadRandom();
            while ()
        }
*/
        //ciudades.ObtenerCiudadRandom(cantCiudades)
    }
/*
    private boolean ciudadPerteneceAEstrategia(Ciudad ciudadParaAgregar){
        for (Ciudad ciudad: ciudades) {
            ciudad.compararCiudad(ciudadParaAgregar);
        }
    }
*/
}
