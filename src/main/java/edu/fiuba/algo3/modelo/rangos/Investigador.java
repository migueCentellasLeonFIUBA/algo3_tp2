package edu.fiuba.algo3.modelo.rangos;



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


    public int getArrestos(){
        return arrestos;
    }
}
