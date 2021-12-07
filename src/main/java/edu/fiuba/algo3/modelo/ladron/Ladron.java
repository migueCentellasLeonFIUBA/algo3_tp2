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

    //hago los metodos para que compile
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

    public boolean esMujer(){
        return (caracteristicas.get(0) == "Mujer");

    }
}
