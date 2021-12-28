package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public abstract class GradoPolicia {
    protected String grado;
    protected Integer velocidad;
    protected Integer arrestos;

    public abstract GradoPolicia arresto();

    public Integer calcularHoras(double distancia){
        return (int) (distancia/velocidad);
    }

    public abstract Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos);

    public abstract String obtenerPista(Edificio edificio);
}
