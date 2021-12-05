package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.jugador.Reloj;

import static java.lang.Math.sqrt;

public class Coordenadas {

    private float latitud;
    private float longitud;

    //Operations
    public int calcularDistancia(Coordenadas destino) {
        //Calculo las distancias con la distancia euclidea.
        float distancia = (float) sqrt( Math.pow(Math.abs(latitud) - Math.abs(destino.getLatitud()), 2) + Math.pow(Math.abs(longitud) - Math.abs(destino.getLongitud()), 2) ) ;
        return Math.round(distancia);
    }

    //opcion2
    public void calcularDistancia(Coordenadas destino,Integer velocidad, Reloj reloj) {
        //Calculo las distancias con la distancia euclidea.
        float distancia = (float) sqrt( Math.pow(Math.abs(latitud) - Math.abs(destino.getLatitud()), 2) + Math.pow(Math.abs(longitud) - Math.abs(destino.getLongitud()), 2) ) ;
        Integer horas = Math.round(distancia / velocidad);
        if (horas == 0)  horas = 1; //Filtro las dsitancias "0".
        reloj.descontarhoras(horas);
    }

    public void setLatitud(float latitud){ this.latitud = latitud;}

    public void setLongitud(float longitud){ this.longitud = longitud;}

    private float getLatitud() {
        return latitud;
    }

    private float getLongitud() {
        return longitud;
    }
    
}
