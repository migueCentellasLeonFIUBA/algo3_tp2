package edu.fiuba.algo3.modelo.rangos;

public class Detective extends GradoPolicia {

    private Integer arrestos = 5;
    private Integer velocidad = 1100;

    @Override
    public void cargarPistas() {

    }

    @Override
    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 10){
            return new Investigador();
        }
        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }
    
}
