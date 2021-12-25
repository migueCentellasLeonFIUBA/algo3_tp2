package edu.fiuba.algo3.modelo.rangos;


public class Sargento extends GradoPolicia {

    private Integer velocidad = 1500;
    private Integer arrestos = 20;


    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;

        return this;
    }


    public String getGrado(){
        return "Sargento";
    }

    public int getArrestos(){
        return arrestos;
    }
}
