package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;

import java.lang.annotation.Inherited;

public abstract class GradoPolicia {

    private Integer arrestos;
    private Integer velocidad;
    protected Pistas pistas;

    public abstract void cargarPistas();

    abstract public Integer calcularTiempoViaje();

    abstract public GradoPolicia arresto();

//    abstract public int getArrestos();

//    abstract public String getGrado();

    abstract public Objeto obtenerObjetoRandom(Objetos objetos);

    public void establecerPistas(Pistas pistas) {
        this.pistas = pistas;
    }

    public String obtenerPistas(String edificio){
        String pista = pistas.ObtenerPista(edificio);
        //pistas.filtrarGrados();
        cargarPistas();
        return pista;
    }

    public void filtrarCiudad(String proximaCiudad) {
        pistas.filtrarCiudades(proximaCiudad);
    }

    abstract public String obtenerGrado();
}
