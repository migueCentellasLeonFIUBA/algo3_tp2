package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;
import edu.fiuba.algo3.modelo.ManejoArchivos.Random;

public class Investigador extends GradoPolicia{

    private Integer arrestos = 10;
    private Integer velocidad =1300;


    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 20){
            return new Sargento();
        }
        return this;
    }
    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos){
        return null;
    }

}
