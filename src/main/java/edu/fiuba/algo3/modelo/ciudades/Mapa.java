package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.util.ArrayList;
import java.util.Map;


public class Mapa {

    private Ciudad ciudadActual;
    private Map<Ciudad, ArrayList<Ciudad>> conexiones;

    public Mapa(Map<Ciudad, ArrayList<Ciudad>> conexiones){
        this.conexiones = conexiones;
    }


    public void viajarACiudad(Ciudad destino, Reloj reloj, GradoPolicia grado){
        ciudadActual.viajarACiudad(destino, reloj, grado);
        this.ciudadActual=destino;
    }

    public ArrayList<Ciudad> posiblesDestinos(){
        return conexiones.get(ciudadActual);
    }

    public void setearCiudadActual(Ciudad ciudad){
        ciudadActual = ciudad;
    }

}