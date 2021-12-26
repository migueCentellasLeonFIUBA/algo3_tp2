package edu.fiuba.algo3.modelo.ciudades;

import java.util.ArrayList;

//Contiene en orden las ciudades por las que se mueve el ladrón.
//pueden ser entre 4 y 7.
public class Ruta {

    private ArrayList<Ciudad> ruta;
    private int ciudadActual;

    public Ruta(){
        ruta = new ArrayList<>();
        ciudadActual = 0;
    }

    public void setCiudadEnRuta(Ciudad ciudad){
        ruta.add(ciudad);
    }

    public Ciudad getProximaCiudadEnRuta(){
        if((ciudadActual +1) < ruta.size()){
            return ruta.get(ciudadActual +1);
        }
        return ruta.get(ciudadActual); //devuelve la misma instancia de ciudad actual, si es la última.
    }

    public Ciudad getCiudadActual(){
        return ruta.get(ciudadActual);
    }

    public void viajarASiguienteCiudad(Ciudad destino){
        if(destino.esLaMismaCiudad(this.getProximaCiudadEnRuta()) && (ciudadActual +1 < ruta.size())){
            ciudadActual +=1; //paso a la siguiente.
        }
    }
}
