package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;

public interface ConstructorCiudad {

    void setNombre(String nombre);
    void setCoordenadas(Double latitud, Double longitud);
    void setDescripcion(String descripcion);
    CiudadNoEstrategia getCiudad();
}
