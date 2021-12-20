package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.jugador.Reloj;

public class Secuaz implements Secuaces{

    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public Secuaz(String nombre){
        this.nombre = nombre;
    }

    @Override
    public boolean arrestar() {
        return false;
    }

    @Override
    public void atacar(Reloj reloj) {

    }

    @Override
    public void setPistola() {

    }

/*
    @Override
    public boolean esLadron(String nombre){
        return false;
    }
*/

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
