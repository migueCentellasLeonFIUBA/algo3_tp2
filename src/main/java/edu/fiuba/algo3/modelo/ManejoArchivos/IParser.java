package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.util.ArrayList;

public interface IParser {

    public IParser parsear(String texto);

    public void filtrar(String termino);

    public String pedirValor(String termino);

    public ArrayList<String> listaDeElementos();

    public long cantidad();

    public ArrayList<String> pedirArreglo(String termino);

    }
