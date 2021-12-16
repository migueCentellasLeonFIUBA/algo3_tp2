package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class DirectorCiudad {
    private ConstructorCiudad constructor;

    public void setConstructorCiudad(ConstructorCiudad constructor){
        this.constructor = constructor;
    }

    public Ciudad getCiudad(){
        return constructor.getCiudad();
    }

    public void construirCiudad(Fachada fachada, String nombreCiudad){

        fachada.filtrar(nombreCiudad);
        constructor.setNombre(nombreCiudad);
        constructor.setCoordenadas( fachada.pedirValor("latitud"), fachada.pedirValor("longitud"));
        constructor.setDescripcion(fachada.pedirValor("descripcion"));
    }

}
