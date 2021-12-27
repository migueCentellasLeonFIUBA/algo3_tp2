package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.IEdificio;

import java.util.ArrayList;

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
}
