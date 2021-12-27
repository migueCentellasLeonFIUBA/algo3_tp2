package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Random;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Novato extends GradoPolicia {

    private Integer velocidad = 900;
    private Integer arrestos = 0;

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 5){
            return new Detective();
        }
        return this;
    }
    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos){
        return null;
    }

    public Integer velocidad(){
        return velocidad;
    }



}
