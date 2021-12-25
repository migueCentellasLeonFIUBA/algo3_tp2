package edu.fiuba.algo3.modelo.IVisitor;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

public class VisitanteConcreto implements Visitante{

    private final GradoPolicia grado;

    public VisitanteConcreto(GradoPolicia unGrado){
        this.grado = unGrado;
    }

}
