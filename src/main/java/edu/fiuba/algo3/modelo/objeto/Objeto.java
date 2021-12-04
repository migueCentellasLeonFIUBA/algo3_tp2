package edu.fiuba.algo3.modelo.objeto;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;

public class Objeto {
    private String nombre;
    private Ciudad ciudad;

    private Objeto(String nombre,Ciudad ciudad) {
        this.ciudad = ciudad;
        this.nombre = nombre;
    }


    public static Objeto crear(String nombre,Ciudad ciudad) {
        return new Objeto(nombre , ciudad);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
