package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;
import edu.fiuba.algo3.modelo.ManejoArchivos.Random;

public class Detective extends GradoPolicia {

    private Integer arrestos = 5;
    private Integer velocidad = 1100;
    private String grado = "Detective";

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 10){
            return new Investigador();
        }
        return this;
    }

    @Override
    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos){
        Random random = new Random();
        Objeto objetoRobado = random.obtenerObjetoRandom(objetos.get("Valioso"));
        return objetoRobado;
    }
    
}
