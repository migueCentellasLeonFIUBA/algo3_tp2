package edu.fiuba.algo3.modelo.IBuilder;


import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ladron.Ladron;

public class DirectorLadron {

    private ConstructorLadron constructor;

    public void setConstructorLadron(ConstructorLadron constructor){
        this.constructor = constructor;
    }

    public Ladron getLadron(){
        return constructor.getLadron();
    }

    public void construirLadron(Fachada fachada, String nombreLadron){

        fachada.filtrar(nombreLadron);
        constructor.setNombre(nombreLadron);
        constructor.setSexo(fachada.pedirValor("Sexo"));
        constructor.setHobby(fachada.pedirValor("Hobby"));
        constructor.setCabello(fachada.pedirValor("Cabello"));
        constructor.setSenia(fachada.pedirValor("Senia"));
        constructor.setVehiculo(fachada.pedirValor("Vehiculo"));
    }

}