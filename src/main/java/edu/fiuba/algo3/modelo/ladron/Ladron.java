package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña.Seña;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;

import java.util.List;

public class Ladron implements Secuaces {

    private Integer ataqueConCuchillo;
    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    private Ladron(List<String> caracteristicas){

        //sexo = caracteristicas.get(0);
        //hobby = caracteristicas.get(1);
        //cabello = caracteristicas.get(2);
        //senia = caracteristicas.get(3);
        //vehiculo = caracteristicas.get(4);
        ataqueConCuchillo = 2;
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
