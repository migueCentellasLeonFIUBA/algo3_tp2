package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.CaracteristicasLadron.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ladron implements Secuaces {

    private Integer ataqueConCuchillo;
    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo){
        this.nombre = nombre;
        this.sexo = sexo;
        this.hobby = hobby;
        this.cabello = cabello;
        this.senia = senia;
        this.vehiculo = vehiculo;
        this.ataqueConCuchillo = 2;
    }

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

}
