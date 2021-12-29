package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Novato extends GradoPolicia {

    public Novato(){
        super.arrestos=0;
        super.velocidad=900;
        super.grado = "Novato";
    }

    public String rango(){
        return "Novato";
    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 5){
            return new Detective();
        }
        return this;
    }

    @Override
    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos) {
        Randomizador random = new Randomizador();
        Objeto objetoRobado = random.obtenerObjetoRandom(objetos.get("Comun"));
        return objetoRobado;
    }

    @Override
    public String obtenerPista(Edificio edificio) {
        return edificio.obtenerPista(this);
    }


}
