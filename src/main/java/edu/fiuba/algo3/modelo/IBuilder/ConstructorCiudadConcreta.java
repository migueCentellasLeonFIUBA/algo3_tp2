package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;


public class ConstructorCiudadConcreta implements ConstructorCiudad {

    private CiudadNoEstrategia ciudad;

    public ConstructorCiudadConcreta(){
        //this.ciudad = new Ciudad();
    }

    @Override
    public void setNombre(String nombre){ ciudad.setNombre(nombre); }

    @Override
    public void setCoordenadas(Double latitud, Double longitud) {
        //ciudad.setCoordenadas(latitud, longitud);
    }

    @Override
    public void setDescripcion(String descripcion){ciudad.setDescripcion(descripcion);}

    @Override
    public CiudadNoEstrategia getCiudad(){return ciudad;}
}
