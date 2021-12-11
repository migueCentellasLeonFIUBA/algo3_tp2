package edu.fiuba.algo3.IBuilder;

import edu.fiuba.algo3.IBuilder.ConstructorLadron;
import edu.fiuba.algo3.modelo.ladron.Ladron;

public class ConstructorLadronConcreto implements ConstructorLadron {

    private Ladron ladron;

    public ConstructorLadronConcreto(){
        this.ladron = new Ladron();
    }

    @Override
    public void setNombre(String nombre){ ladron.setNombre(nombre); }

    @Override
    public void setSexo(String sexo){
        ladron.setSexo(sexo);
    }

    @Override
    public void setHobby(String hobby){
        ladron.setHobby(hobby);
    }

    @Override
    public void setCabello(String cabello){
        ladron.setCabello(cabello);
    }

    @Override
    public void setSenia(String senia){
        ladron.setSenia(senia);
    }

    @Override
    public void setVehiculo(String vehiculo){
        ladron.setVehiculo(vehiculo);
    }

    @Override
    public Ladron getLadron(){return ladron;}

}