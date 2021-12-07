package edu.fiuba.algo3.modelo.rangos;


import java.lang.annotation.Inherited;

public class Novato extends GradoPolicia {

    private Integer velocidad = 900;
    private Integer arrestos = 0;


    @Override
    public void cargarPistas() {

    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 5){
            return new Detective();
        }
        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }

    @Override
    public String getGrado(){
        return "Novato";
    }

    public int getArrestos(){
        return arrestos;
    }


}
