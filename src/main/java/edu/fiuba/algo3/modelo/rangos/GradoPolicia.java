package edu.fiuba.algo3.modelo.rangos;

public abstract class GradoPolicia {

    private Integer arrestos;

    abstract void cargarPistas();

    abstract public Integer calcularTiempoViaje();
    abstract public GradoPolicia arresto();

}
