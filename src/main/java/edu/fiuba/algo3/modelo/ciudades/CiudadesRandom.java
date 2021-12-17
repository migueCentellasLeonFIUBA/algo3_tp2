package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.ManejoArchivos.Random;

import java.util.ArrayList;

//guarda una lista de ciudades y devuelve la cantidad de ciudades necesarias.
public class CiudadesRandom {

    ArrayList<Ciudad> ciudades = new ArrayList<>();

    public CiudadesRandom(ArrayList<Ciudad>  listaCiudades){
        this.ciudades = listaCiudades;
    }

    public ArrayList<Ciudad> getCiudadesRandom(Ciudad ciudadOrigen, int cantCiudades){
        //dado un nombre obtengo ciudades random..
        //uso una lista auxiliar:

        ArrayList<Ciudad> ciudadesRandom = new ArrayList<>();
        ArrayList<Ciudad> ciudadesAux = ciudades;
        Random random = new Random();

        Ciudad ciudadRandom;
        ciudadesRandom.add(ciudadOrigen); //la primra dpende el objeto
        int tope = cantCiudades -1;
        int posicion = 0;

        while (tope > 0){
            posicion = random.obtenerNumeroRandom(ciudadesAux.size());
            ciudadRandom = ciudadesAux.get(posicion);

            if (ciudadRandom.esLaMismaCiudad(ciudadOrigen)){
                //agrego a los resultados
                ciudadesRandom.add(ciudadRandom);

                //saco la ciudad para que no se repita
                ciudadesAux.remove(posicion);

                //actualizo la condicion del while
                tope -=1;
            }
        }

        return ciudadesRandom;

    }
}
