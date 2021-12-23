package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.pistas.Pista;

import java.lang.annotation.Inherited;

public class Novato extends GradoPolicia {

    private Integer velocidad = 900;
    private Integer arrestos = 0;


    @Override
    public void cargarPistas() {
        pistas.filtrarGrados("Facil");
    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 5){
            return new Detective();
        }
        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }

    public Objeto obtenerObjetoRandom(Objetos objetos) {
        return objetos.ObtenerObjetoRandom("Comun");
    }

    @Override
    public Pista obtenerPista(Edificio edificio) {
        return edificio.obtenerPista(this);
    }
}
