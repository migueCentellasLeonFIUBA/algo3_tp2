package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
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
        Ciudad ciudadAnterior;

        ciudadActual.viajarACiudad(destino, reloj, grado);

        ciudadAnterior = ciudadActual;
        this.ciudadActual = destino;

        ciudadActual.agregarConexion(this, ciudadAnterior);
    }

    public ArrayList<Ciudad> posiblesDestinos(){
        return conexiones.get(ciudadActual);
    }

    public void setearCiudadActual(Ciudad ciudad){
        ciudadActual = ciudad;
    }

    public void agregarConexion(Ciudad ciudad){
        posiblesDestinos().add(ciudad);
    }

    public  ArrayList<Edificio> edificiosDeCiudadActual() {
        return ciudadActual.MostrarEdificios();
    }

    public String visitarEdificio(Edificio edificio, Jugador jugador) {
        return ciudadActual.visitarEdificio(edificio,jugador);
    }
}