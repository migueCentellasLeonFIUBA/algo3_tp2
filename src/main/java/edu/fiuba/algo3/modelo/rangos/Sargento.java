package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Random;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Sargento extends GradoPolicia {

    private Integer velocidad = 1500;
    private Integer arrestos = 20;


    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;

        return this;
    }

    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos){
        return null;
    }

}
