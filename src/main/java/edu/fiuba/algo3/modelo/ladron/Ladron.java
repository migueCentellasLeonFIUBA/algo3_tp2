package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña.Seña;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ladron implements Secuaces {

    private Integer ataqueConCuchillo;
    private String nombre;
    private Sexo sexo;
    private Hobby hobby;
    private Cabello cabello;
    private Seña senia;
    private Vehiculo vehiculo;



    private Ladron(List<String> caracteristicas){

        //sexo = caracteristicas.get(0);
        //hobby = caracteristicas.get(1);
        //cabello = caracteristicas.get(2);
        //senia = caracteristicas.get(3);
        //vehiculo = caracteristicas.get(4);
        ataqueConCuchillo = 2;
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
/*
    public boolean compararSexo(Sexo sexo){
        return sexo.compararSexo(this.sexo);

    }

    public boolean compararNombre(String nombre){
        return (nombre == this.nombre);
    }

    public boolean compararVehiculo(Vehiculo vehiculo){
        return vehiculo.compararVehiculo(this.vehiculo);
    }

    public boolean compararSenia(Seña seña){
        return seña.compararSeña(this.senia);
    }

    public boolean compararHobby(Hobby hobby){
        return hobby.compararHobby(this.hobby);
    }

    public boolean compararCabello(Cabello cabello){
        return cabello.compararCabello(this.cabello);
    }

    public boolean compararLadrones(Sexo sexo, Hobby hobby, Cabello cabello, Vehiculo vehiculo, Seña senia){

        if(!(this.compararSexo(sexo))){
            return false;
        }

        if(!(this.compararHobby(hobby))){
            return false;
        }

        if(!(this.compararCabello(cabello))){
            return false;
        }

        if(!(this.compararVehiculo(vehiculo))){
            return false;
        }

        if(!(this.compararSenia(senia))){
            return false;
        }


        return true;
    }
*/
}
