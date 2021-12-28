package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public abstract class GradoPolicia {
    private Integer velocidad;
    private Integer arrestos = 10;

    public abstract GradoPolicia arresto();

    public Integer calcularHoras(double distancia){
        return (int) (distancia/velocidad);
    }


    public abstract Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos);
}
