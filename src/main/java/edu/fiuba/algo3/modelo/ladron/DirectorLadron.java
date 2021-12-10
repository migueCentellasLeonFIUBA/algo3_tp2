package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.CaracteristicasLadron.*;
import org.json.simple.JSONObject;


public class DirectorLadron {

    private ConstructorLadron constructor;

    public void setConstructorLadron(ConstructorLadron constructor){
        this.constructor = constructor;
    }

    public Ladron getLadron(){
        return constructor.getLadron();
    }

    public void construirLadron(JSONObject js){

        constructor.setNombre((String) js.get("Nombre"));
        constructor.setSexo((String) js.get("Sexo"));
        constructor.setHobby((String) js.get("Hobby"));
        constructor.setCabello((String) js.get("Cabello"));
        constructor.setSenia((String) js.get("Senia"));
        constructor.setVehiculo((String) js.get("Vehiculo"));

    }

}
