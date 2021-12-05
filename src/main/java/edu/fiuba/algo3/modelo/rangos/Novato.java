package edu.fiuba.algo3.modelo.rangos;



public class Novato implements GradoPolicia {

    private Integer velocidad = 900;

    @Override
    public void cargarPistas() {

    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }
    
}
