package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;

import java.util.List;

public class Ladron implements Secuaces {

    private Integer ataqueConCuchillo;
    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    //Operations
    @Override
    public boolean Arrestar() {
        //TODO
        return true;
    }

    public void atacarConCuchillo(Reloj reloj){
        reloj.descontarhoras(ataqueConCuchillo);
        if(ataqueConCuchillo == 2){
            ataqueConCuchillo--;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }

    public void setSenia(String senia) {
        this.senia = senia;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
}
