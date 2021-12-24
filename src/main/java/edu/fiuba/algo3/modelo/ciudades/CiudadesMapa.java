package edu.fiuba.algo3.modelo.ciudades;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Random;

//guarda una lista de ciudades y devuelve la cantidad de ciudades necesarias.
public class CiudadesMapa {

        ArrayList<Ciudad> ciudades;

        public CiudadesMapa(ArrayList<Ciudad> listaCiudades){
            this.ciudades = listaCiudades;
        }

        public Ciudad getCiudad(String nombre){

            for(Ciudad ciudad : ciudades){
                if(ciudad.esLaMismaCiudad(nombre)){
                    return ciudad; //si o si devuelve una instancia de ciudad.
                }
            }

            return new Ciudad(); //nunca llega a esta instancia.
        }

        private Boolean perteneceAEstrategia(ArrayList<Ciudad> estrategia, Ciudad ciudad){
            Integer ciudadActual;
            for(ciudadActual = estrategia.size() - 1; ciudadActual >= 0; ciudadActual--){
                if(ciudad.esLaMismaCiudad(estrategia.get(ciudadActual))){
                    return true;
                }
            }
            return false;
        }

        public ArrayList<Ciudad> getCiudadesRandom(Ciudad ciudadOrigen, int cantCiudades){
            //dado un nombre obtengo ciudades random..
            //uso una lista auxiliar:

            ArrayList<Ciudad> ciudadesRandom = new ArrayList<>();
            ArrayList<Ciudad> ciudadesAux = ciudades;
            Random random = new Random();

            Ciudad ciudadRandom;
            ciudadesRandom.add(ciudadOrigen); //la primera depende el objeto.
            int tope = cantCiudades -1;
            int posicion = 0;

            while (tope > 0){
                posicion = random.nextInt(ciudadesAux.size());
                ciudadRandom = ciudadesAux.get(posicion);

                if (!(perteneceAEstrategia(ciudadesRandom, ciudadRandom))){
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

