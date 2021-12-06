package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Objeto {
    private String nombre;
    private Valor valor;

    private Objeto(String nombre) {
        this.nombre = nombre;
    }


    public static Objeto crear(String nombre) {
        return new Objeto(nombre);
    }


    public Estrategia crearEstrategia(Ciudad ciudad){
        return(valor.crearEstrategia(ciudad));

    }
}
