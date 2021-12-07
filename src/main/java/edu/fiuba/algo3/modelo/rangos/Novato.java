package edu.fiuba.algo3.modelo.rangos;


public class Novato extends GradoPolicia {

    private Integer velocidad = 900;
    private Integer arrestos = 0;

    @Override
    public void cargarPistas() {

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

    public Boolean dificultadPista(String pista){

        //harcodeo
        if(pista == "Facil"){
            return true;
        }
        return false;
    }
    
}
