package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;
import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;

public class Investigador extends GradoPolicia{

    private Integer arrestos = 10;
    private Integer velocidad =1300;
    private String grado = "Investigador";


    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 20){
            return new Sargento();
        }
        return this;
    }

    @Override
    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos) {
        Randomizador random = new Randomizador();
        Objeto objetoRobado = random.obtenerObjetoRandom(objetos.get("Valioso"));
        return objetoRobado;
    }

}
