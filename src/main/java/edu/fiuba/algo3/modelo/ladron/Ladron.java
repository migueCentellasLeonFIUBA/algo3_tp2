package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Armas.Arma;
import edu.fiuba.algo3.modelo.ladron.Armas.Cuchillo;
import edu.fiuba.algo3.modelo.ladron.Armas.Pistola;

public class Ladron implements Secuaces {

    public Arma arma;

    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public Ladron(){
        arma = new Cuchillo();
    }

    //Operations
    @Override
    public boolean arrestar() {
        return true;
    }
/*
    @Override
    public boolean esLadron(String nombre){
        return this.nombre.equals(nombre);
    }
*/

    public void atacar(Reloj reloj){
        arma.atacar(reloj);
    }

    @Override
    public void setPistola() {
        arma = new Pistola();
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
