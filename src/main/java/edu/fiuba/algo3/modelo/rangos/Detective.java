package edu.fiuba.algo3.modelo.rangos;

public class Detective implements GradoPolicia {

    private Integer velocidad = 1100;

    @Override
    public void cargarPistas() {

    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }
    
}
