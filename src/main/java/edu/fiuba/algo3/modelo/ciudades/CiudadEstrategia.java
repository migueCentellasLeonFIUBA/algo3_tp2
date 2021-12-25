package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.IEdificio;

import java.util.ArrayList;

public class CiudadEstrategia extends Ciudad{
    Coordenadas coordenadas;
    String nombreCiudad;
    String descripcion;
    ArrayList<IEdificio> edificios;

    public CiudadEstrategia(String nombreCiudad,String descripcion,Coordenadas coordenadas,ArrayList<IEdificio> edificios) {
        this.nombreCiudad = nombreCiudad;
        this.descripcion = descripcion;
        this.coordenadas = coordenadas;
        this.edificios = edificios;
    }
}
