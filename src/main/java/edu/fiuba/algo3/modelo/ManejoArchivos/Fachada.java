package edu.fiuba.algo3.modelo.ManejoArchivos;

public class Fachada implements IFachada{

    IGestorDeArchivos gestorDeArchivos;

    public Fachada(IGestorDeArchivos gestor){
        gestorDeArchivos=gestor;
    }
    public IParser nuevoParser(){
        return new ParserJson(gestorDeArchivos);
    }
}
