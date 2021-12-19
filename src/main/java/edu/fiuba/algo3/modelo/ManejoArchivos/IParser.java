package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.util.ArrayList;

public interface IParser {
    public void filtrar(String termino);

    public void volverAFiltrar(String termino);

    public String pedirValor(String termino);

    public ArrayList<String> listaDeElementos();

    public long cantidad();
}
