package edu.fiuba.algo3.modelo.ciudades;

import static java.lang.Math.sqrt;

public class Coordenadas {

    private double latitud;
    private double longitud;


    public Coordenadas(double latitud, double longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double calcularDistancia(Coordenadas destino) {
        //Calculo las distancias con la distancia euclidea.
        Integer pasajeAKm = 100;
        double distancia = pasajeAKm * (sqrt( Math.pow(Math.abs(latitud) - Math.abs(destino.getLatitud()), 2) + Math.pow(Math.abs(longitud) - Math.abs(destino.getLongitud()), 2) ));
        return Math.round(distancia);
    }

    private double getLatitud() {
        return latitud;
    }
    private double getLongitud() {
        return longitud;
    }
    
}
