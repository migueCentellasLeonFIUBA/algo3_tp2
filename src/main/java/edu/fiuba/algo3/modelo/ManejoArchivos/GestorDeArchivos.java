package edu.fiuba.algo3.modelo.ManejoArchivos;

import java.io.*;

import java.util.stream.Collectors;

public class GestorDeArchivos implements IGestorDeArchivos {

    public GestorDeArchivos(){}

    public String leerTextoCompleto(String ruta) throws FileNotFoundException {
        File file = new File(ruta);
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br.lines().collect(Collectors.joining());
    }

    public String AgregarTexto(String ruta,String textoNuevo) throws FileNotFoundException {
        File file = new File(ruta);

        return ruta;
    }


    }
