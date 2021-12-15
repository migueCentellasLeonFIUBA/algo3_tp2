package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;


public class ConstructorCiudadConcreta implements ConstructorCiudad {

    private Ciudad ciudad;

    public ConstructorCiudadConcreta(){
        this.ciudad = new Ciudad();
    }

    @Override
    public void setNombre(String nombre){ ciudad.setNombre(nombre); }

    @Override
    public void setCoordenadas(String latitud, String longitud) {
        ciudad.setCoordenadas(latitud, longitud);
    }

    @Override
    public void setDescripcion(String descripcion){ciudad.setDescripcion(descripcion);}

    @Override
    public Ciudad getCiudad(){return ciudad;}
}
