package edu.fiuba.algo3.modelo.rangos;

import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.pistas.Pista;

public class Detective extends GradoPolicia {

    private Integer arrestos = 5;
    private Integer velocidad = 1100;
    private String grado = "Detective";

    @Override
    public void cargarPistas() {
        pistas.filtrarGrados("Media");
    }

    @Override
    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 10){
            return new Investigador();
        }
        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }

    @Override
    public Objeto obtenerObjetoRandom(Objetos objetos) {
        return objetos.ObtenerObjetoRandom("Valioso");
    }

    @Override
    public Pista obtenerPista(Edificio edificio) {
        return edificio.obtenerPista(this);
    }

}

