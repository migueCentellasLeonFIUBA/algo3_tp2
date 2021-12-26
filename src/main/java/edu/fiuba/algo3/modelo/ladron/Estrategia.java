
package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesMapa;
import edu.fiuba.algo3.modelo.ciudades.Ruta;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {

    private List<Ciudad> ciudades;
    private Integer siguiente = 0;
    private CiudadesMapa ciudadesMapa;
    private Ruta ruta;

    //*************Metodos para rutas estaticas**************

    public Estrategia(Ruta ruta) {
        this.ruta = ruta;
    }

    //si es la actual es la ultima, devuelve la misma instancia de ciudad.
    public Ciudad getProximaCiudadEnRuta(){
        return ruta.getProximaCiudadEnRuta();
    }

    public Ciudad getCiudadActual(){
        return ruta.getCiudadActual();
    }

    public void viajarASiguienteCiudad(Ciudad destino){
        ruta.viajarASiguienteCiudad(destino);
    }

    //**********metodos para rutas random***********
/*
    public Estrategia(Integer cantCiudades, Ciudad ciudad, CiudadesMapa ciudades) {
        this.ciudades = new ArrayList<>();
        this.ciudades.add(ciudad);
        this.ciudadesMapa = ciudades; //le pasa una lista de las ciudades cargadas....
        //this.ciudadActual = ciudad;
        this.asignarEstrategiaRandom(cantCiudades, ciudad);
    }

    //devuelve la proxima ciudad en la ruta.
    public Ciudad getProximaCiudad() {
        siguiente += 1;
        Ciudad siguienteCiudad = new Ciudad();

        if(siguiente < ciudades.size()){
            siguienteCiudad = ciudades.get(siguiente);
        }
        return siguienteCiudad;
    }

    private void asignarEstrategiaRandom(Integer cantCiudades, Ciudad ciudadOrigen){
        this.ciudades = ciudadesMapa.getCiudadesRandom(ciudadOrigen, cantCiudades); //este debe cambiar a getCiudadesRuta...
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
         ArrayList<Ciudad> posiblesDestinos = ciudadesMapa.getCiudadesRandom(ciudades.get(siguiente), 3);
         posiblesDestinos.add(ciudades.get(siguiente +1));
         return posiblesDestinos;
    }
 */

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
