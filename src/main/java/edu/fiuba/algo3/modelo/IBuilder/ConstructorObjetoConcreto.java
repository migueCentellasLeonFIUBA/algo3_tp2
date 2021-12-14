package edu.fiuba.algo3.modelo.IBuilder;

import edu.fiuba.algo3.modelo.objetos.Objeto;

public class ConstructorObjetoConcreto implements ConstructorObjeto{

    private Objeto objeto;

    public ConstructorObjetoConcreto(){
        this.objeto = new Objeto();
    }

    @Override
    public void setNombre(String nombre){ objeto.setNombre(nombre); }

    @Override
    public void setOrigen(String origen){
        objeto.setOrigen(origen);
    }

    @Override
    public void setValor(String clase){objeto.setValor(clase);}

    @Override
    public Objeto getObjeto(){return objeto;}
}
