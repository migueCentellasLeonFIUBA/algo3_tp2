package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Armas.Arma;
import edu.fiuba.algo3.modelo.ladron.Armas.Cuchillo;
import edu.fiuba.algo3.modelo.ladron.Armas.Pistola;

import java.util.ArrayList;

public class Ladron implements Secuaces {

    public Arma arma;

    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    private ArrayList<String> pistas;

    public Ladron(){
        arma = new Cuchillo();
        pistas = new ArrayList<>();
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
        pistas.add(sexo);
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
        pistas.add(hobby);
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
        pistas.add(cabello);
    }

    public void setSenia(String senia) {
        this.senia = senia;
        pistas.add(senia);
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
        pistas.add(vehiculo);
    }

    //refactorizar , modelando de la misma forma que las pistas
    public String getPista(){
        //de forma random, devuelve un valor del ladron...

        //devuelvo las pistas desencolando
        String pista = pistas.get(0);
        pistas.remove(0);

        return pista;
    }
}
