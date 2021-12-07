package edu.fiuba.algo3.modelo.rangos;


public class Sargento extends GradoPolicia {

    private Integer velocidad = 1500;
    private Integer arrestos = 20;

    @Override
    public void cargarPistas() {

    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;

        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }
    
}
