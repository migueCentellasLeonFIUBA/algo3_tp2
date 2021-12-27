package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.IEdificio;

import java.util.ArrayList;

public class CiudadLadron extends Ciudad{
    public CiudadLadron(String nombreCiudad, String descripcion, Coordenadas coordenadas, ArrayList<IEdificio> edificios) {
        super(nombreCiudad,descripcion,coordenadas,edificios);
    }
}
