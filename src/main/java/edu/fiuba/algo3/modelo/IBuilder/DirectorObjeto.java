package edu.fiuba.algo3.modelo.IBuilder;

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

        fachada.filtrar(nombreObjeto);
        constructor.setNombre(nombreObjeto);
        constructor.setOrigen(fachada.pedirValor("CiudadDeOrigen"));
        constructor.setValor(fachada.pedirValor("Rareza"));
    }
}
