package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ladron implements Secuaces {

    private Integer ataqueConCuchillo;
    private List<String> caracteristicas;

    private Ladron(List<String> caracteristicas){
        this.caracteristicas =caracteristicas;
        this.ataqueConCuchillo = 2;
    }

    public static Ladron crear(List<String> caracteristicas) {
        return new Ladron(caracteristicas);
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

    public boolean compararSexo(String sexo){
        return (caracteristicas.get(1) == sexo);

    }

    public boolean compararNombre(String nombre){
        return (caracteristicas.get(0) == nombre);
    }

    public boolean compararVehiculo(String vehiculo){
        return (caracteristicas.get(5) == vehiculo);
    }

    public boolean compararSeña(String seña){
        return (caracteristicas.get(4) == seña);
    }

    public boolean compararHobby(String hobby){
        return (caracteristicas.get(2) == hobby);
    }

    public boolean compararCabello(String cabello){
        return (caracteristicas.get(3) == cabello);
    }

}
