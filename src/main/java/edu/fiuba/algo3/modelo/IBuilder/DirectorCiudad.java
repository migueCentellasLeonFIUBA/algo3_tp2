package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;

public class DirectorCiudad {
    private ConstructorCiudad constructor;

    public DirectorCiudad(ConstructorCiudad constructor){
        this.constructor = constructor;
    }

    public CiudadNoEstrategia getCiudad(){
        return constructor.getCiudad();
    }

    public void construirCiudad(String nombre,Double latitud,Double longitud, String descripcion){

        constructor.setNombre(nombre);
        constructor.setCoordenadas( latitud, longitud);
        constructor.setDescripcion(descripcion);
    }

}
