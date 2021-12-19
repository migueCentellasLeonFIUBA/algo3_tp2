package edu.fiuba.algo3.modelo.ManejoArchivos;

public interface IFachada {

    public IFachada(IGestorDeArchivos gestor);
    public IParser nuevoParser();
    public String texto cargarPistas();
}
