package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.lang.annotation.Inherited;

public abstract class GradoPolicia {

    private Integer arrestos;
    private Integer velocidad;

    abstract void cargarPistas();

    abstract public Integer calcularTiempoViaje();

    abstract public GradoPolicia arresto();

//    abstract public int getArrestos();

//    abstract public String getGrado();
    abstract public Objeto obtenerObjetoRandom(Objetos objetos);
}
