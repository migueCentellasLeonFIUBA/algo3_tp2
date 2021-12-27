package edu.fiuba.algo3.modelo.objetos;


import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

import java.util.Map;

public class Objeto{

    private Estrategia estrategia;
    private String nombre;

    public Objeto(String nombre, Estrategia estrategia){
        this.nombre = nombre;
        this.estrategia= estrategia;
    }

    public void aplicarEstrategia(Map<String, Ciudad> ciudades) {
        estrategia.aplicarEstrategia(ciudades);
    }
}
