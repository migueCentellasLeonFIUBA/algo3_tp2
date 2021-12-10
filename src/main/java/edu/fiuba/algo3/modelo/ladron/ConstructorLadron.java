package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.CaracteristicasLadron.*;

public interface ConstructorLadron {

    void setNombre(String nombre);
    void setSexo(String sexo);
    void setHobby(String hobby);
    void setCabello(String cabello);
    void setSenia(String senia);
    void setVehiculo(String vehiculo);
    Ladron getLadron();

}
