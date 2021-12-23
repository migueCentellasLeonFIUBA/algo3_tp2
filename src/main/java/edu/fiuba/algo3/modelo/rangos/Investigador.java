package edu.fiuba.algo3.modelo.rangos;


import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.pistas.Pista;

public class Investigador extends GradoPolicia{

    private Integer arrestos = 10;
    private Integer velocidad =1300;

    @Override
    public void cargarPistas() {
        pistas.filtrarGrados("Media");
    }

    public GradoPolicia arresto() {
        this.arrestos = this.arrestos + 1;
        if(this.arrestos == 20){
            return new Sargento();
        }
        return this;
    }

    @Override
    public Integer calcularTiempoViaje() {
        return velocidad;
    }

    public Objeto obtenerObjetoRandom(Objetos objetos) {
        return objetos.ObtenerObjetoRandom("Valioso");
    }

    @Override
    public Pista obtenerPista(Edificio edificio) {
        return edificio.obtenerPista(this);
    }

}

