package edu.fiuba.algo3.modelo.rangos;


public class Sargento implements GradoPolicia {

    private Integer velocidad = 1500;

    @Override
    public void cargarPistas() {

    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }
    
}
