package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.objetos.Objeto;

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


    public Objeto solicitarObjeto(Juego juego){

        //POSIBLE REFATOR UNA CLASE POR TIPO Y PEDIRLE A ELLA.
        //return juego.ObjetoAleatorio("Comun");
        return null;
    }


}
