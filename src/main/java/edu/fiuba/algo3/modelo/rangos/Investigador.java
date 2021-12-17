package edu.fiuba.algo3.modelo.rangos;



public class Investigador extends GradoPolicia{

    private Integer arrestos = 10;
    private Integer velocidad =1300;

    @Override
    public void cargarPistas() {
        pistas.filtrarPistas("Investigador");
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

    @Override
    public String getGrado() {
        return "Investigador";
    }

    public int getArrestos(){
        return arrestos;
    }
}
