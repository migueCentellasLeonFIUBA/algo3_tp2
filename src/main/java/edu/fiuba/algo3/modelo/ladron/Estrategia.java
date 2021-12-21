
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesRandom;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private Integer siguiente = 0;
    private CiudadesRandom ciudadesRandom;
//    private Ciudad ciudadActual;


    public Estrategia(Integer cantCiudades, Ciudad ciudad, Ciudades ciudades) {
        this.ciudades = new ArrayList<>();
        this.ciudades.add(ciudad);
        this.ciudadesRandom = new CiudadesRandom(ciudades.crearCiudades());
//        this.ciudadActual = ciudad;
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

    public void actualizarCiudad(Ciudad ciudad){
        for (Ciudad ciudadDeLaEstrategia: ciudades) {
            if(ciudad.esLaMismaCiudad(ciudadDeLaEstrategia))
                siguiente++;
                break;
        }
        return;
    }

    public ArrayList<Ciudad> obtenerSiguientesDestinos(){
         ArrayList<Ciudad> posiblesDestinos = ciudadesRandom.getCiudadesRandom(ciudades.get(siguiente), 3);
         posiblesDestinos.add(ciudades.get(siguiente +1));
         return posiblesDestinos;
    }

/*
    public void viajarACiudad(Ciudad destino, GradoPolicia grado, Reloj reloj) {
        ciudadActual.calcularDistancia(destino, grado.calcularTiempoViaje(), reloj);
        ciudadActual = destino;
        actualizarCiudad(ciudadActual);
    }

    public String visitarEdificio(Edificio edificio, Reloj reloj, Visitante visitante) throws FileNotFoundException {

        return ciudadActual.visitarEdificio(edificio, reloj, visitante);
    }

*/
}
