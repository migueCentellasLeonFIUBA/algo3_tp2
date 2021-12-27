package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.Map;

public abstract class GradoPolicia {


    public abstract GradoPolicia arresto();

    //public abstract Caso crearCaso(Map<String, ArrayList<Objeto>> objetos);

    public abstract Objeto ObtenerObjeto(Map<String, ArrayList<Objeto>> objetos);

    public abstract Integer velocidad();
}
