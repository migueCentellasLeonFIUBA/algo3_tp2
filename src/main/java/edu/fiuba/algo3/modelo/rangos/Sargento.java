package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public class Sargento extends GradoPolicia {

    public Sargento(){
        super.arrestos=20;
        super.velocidad=1500;
        super.grado = "Sargento";
    }

    public String rango(){
        return "Sargento";
    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;

        return this;
    }

    @Override
    public Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos) {
        Randomizador random = new Randomizador();
        Objeto objetoRobado = random.obtenerObjetoRandom(objetos.get("Muy Valioso"));
        return objetoRobado;
    }

    @Override
    public String obtenerPista(Edificio edificio) {
        return edificio.obtenerPista(this);
    }

}
