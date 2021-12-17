package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;

public class AeroPuerto implements Edificio {

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public String aceptar(Visitante unVisitante) {
        return unVisitante.visitar(this);
    }

}
