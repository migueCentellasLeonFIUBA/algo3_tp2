package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;


public class ConstructorCiudadConcreta {

    private CiudadNoEstrategia ciudad;

    public ConstructorCiudadConcreta(){
        //this.ciudad = new Ciudad();
    }


    public void setCoordenadas(Double latitud, Double longitud) {
        //ciudad.setCoordenadas(latitud, longitud);
    }

    public void setDescripcion(String descripcion){ciudad.setDescripcion(descripcion);}

    public CiudadNoEstrategia getCiudad(){return ciudad;}
}
