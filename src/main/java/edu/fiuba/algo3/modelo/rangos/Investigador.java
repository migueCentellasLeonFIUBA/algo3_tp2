package edu.fiuba.algo3.modelo.rangos;



public class Investigador implements GradoPolicia{

    private Integer velocidad =1300;

    @Override
    public void cargarPistas() {

    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }
    
}
