package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;

public abstract class GradoPolicia {

    private Integer arrestos;
    private Integer velocidad;
    protected Pistas pistas;

    public abstract void cargarPistas();

    abstract public Integer calcularTiempoViaje();

    abstract public GradoPolicia arresto();

    abstract public int getArrestos();

    abstract public String getGrado();

    public void establecerPistas(Pistas pistas) {
        this.pistas = pistas;
    }

    public String obtenerPistas(String edificio){
        return pistas.ObtenerPista(edificio);
    }

    public void filtrarCiudad(String proximaCiudad) {
        pistas.filtrarCiudades(proximaCiudad);
    }
}
