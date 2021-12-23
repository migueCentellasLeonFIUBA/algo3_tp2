package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.pistas.Pista;

public class Sargento extends GradoPolicia {

    private Integer velocidad = 1500;
    private Integer arrestos = 20;;

    @Override
    public void cargarPistas() {
        pistas.filtrarGrados("Dificil");
    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;

        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }

    public Objeto obtenerObjetoRandom(Objetos objetos) {
        return objetos.ObtenerObjetoRandom("Muy Valioso");
    }

    @Override
    public Pista obtenerPista(Edificio edificio) {
        return edificio.obtenerPista(this);
    }
}
