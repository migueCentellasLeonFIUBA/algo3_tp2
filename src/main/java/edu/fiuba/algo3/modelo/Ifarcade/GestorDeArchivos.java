package edu.fiuba.algo3.modelo.Ifarcade;

import java.io.*;

import java.util.stream.Collectors;

public class GestorDeArchivos {

    private String carpetaArchivos;

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
