package edu.fiuba.algo3.modelo.ladron;

import java.util.ArrayList;

public interface ISospechable {
    public Sospechoso comparar(ArrayList<String> caracteristicas);

    public boolean arrestar();

    String dameUnaPista();

    String obtenerSexo();

    String getNombre();

}
