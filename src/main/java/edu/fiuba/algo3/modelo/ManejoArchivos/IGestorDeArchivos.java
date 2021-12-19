package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.io.FileNotFoundException;

public interface IGestorDeArchivos {

    public String leerTextoCompleto(String ruta) throws FileNotFoundException;

    public String AgregarTexto(String ruta,String textoNuevo) throws FileNotFoundException;

}
