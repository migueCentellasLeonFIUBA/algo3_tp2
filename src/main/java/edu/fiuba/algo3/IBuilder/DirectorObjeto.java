package edu.fiuba.algo3.IBuilder;

import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.objetos.Objeto;

public class DirectorObjeto {
    private ConstructorObjeto constructor;

    public void setConstructorObjeto(ConstructorObjeto constructor){
        this.constructor = constructor;
    }

    public Objeto getObjeto(){
        return constructor.getObjeto();
    }

    public void construirObjeto(Fachada fachada, String nombreObjeto){

        constructor.setNombre(fachada.pedirValor("nombre")); //???
        //constructor.setNombre(nombreObjeto);
        constructor.setNombre(fachada.pedirValor("CiudadDeOrigen"));
        constructor.setNombre(fachada.pedirValor("Rareza"));
    }
}
