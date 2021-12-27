package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.ManejoArchivos.Random;
import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.LadronNulo;

import java.util.ArrayList;
import java.util.Map;

public abstract class Ciudad {
    private final Coordenadas coordenadas;
    private final String nombreCiudad;
    private final String descripcion;
    private final ArrayList<IEdificio> edificios;


    public Ciudad(String nombreCiudad,String descripcion,Coordenadas coordenadas,ArrayList<IEdificio> edificios) {
        this.nombreCiudad = nombreCiudad;
        this.descripcion = descripcion;
        this.coordenadas = coordenadas;
        this.edificios = edificios;
    }

    public ArrayList<IEdificio> MostrarEdificios() {
        return this.edificios;
    }

    public void cambiarPistas(Map<String, IPista> pistasEdificios, Ladron ladron) {
        Random random = new Random();
        Integer posEdificioRandom = random.obtenerIntegerRandom(pistasEdificios.size());
        Integer indice=0;
        for(IEdificio edificio: edificios){
           if(indice==posEdificioRandom){
               edificio.cambiarPista(pistasEdificios, ladron);
           }else{
               edificio.cambiarPista(pistasEdificios,new LadronNulo());
           }
        }
    }
}
