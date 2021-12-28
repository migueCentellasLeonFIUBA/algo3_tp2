package edu.fiuba.algo3.modelo.objetos;


import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.ladron.Ladron;

import java.util.Map;

public class Objeto{

    private Estrategia estrategia;
    private String nombre;

    public Objeto(String nombre, Estrategia estrategia){
        this.nombre = nombre;
        this.estrategia= estrategia;
    }

    public void aplicarEstrategia(Map<String, Ciudad> ciudades, Map<String, Map<String, IPista>> pistas, Ladron ladron, Mapa mapa) {
        estrategia.aplicarEstrategia(ciudades, pistas,ladron,mapa);
    }

    public String getCiudadDeOrigen() {
        return estrategia.getCiudadDeOrigen();
    }

    public String getNombre() {
        return nombre;
    }
}
