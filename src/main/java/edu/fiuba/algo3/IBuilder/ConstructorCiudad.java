package edu.fiuba.algo3.IBuilder;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public interface ConstructorCiudad {

    void setNombre(String nombre);
    void setCoordenadas(String latitud, String longitud);
    void setDescripcion(String descripcion);
    Ciudad getCiudad();
}
