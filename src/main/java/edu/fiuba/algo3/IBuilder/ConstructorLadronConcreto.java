package edu.fiuba.algo3.IBuilder;

import edu.fiuba.algo3.IBuilder.ConstructorLadron;
import edu.fiuba.algo3.modelo.ladron.Ladron;

public class ConstructorLadronConcreto implements ConstructorLadron {

    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    @Override
    public void setNombre(String nombre){ this.nombre = nombre; }

    @Override
    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    @Override
    public void setHobby(String hobby){
        this.hobby = hobby;
    }

    @Override
    public void setCabello(String cabello){
        this.cabello = cabello;
    }

    @Override
    public void setSenia(String senia){
        this.senia = senia;
    }

    @Override
    public void setVehiculo(String vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public Ladron getLadron(){return new Ladron(nombre, sexo, hobby, cabello, senia, vehiculo);}

}