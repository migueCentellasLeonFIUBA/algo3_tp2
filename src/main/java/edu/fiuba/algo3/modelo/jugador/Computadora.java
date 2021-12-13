package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña.Seña;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaz;

import java.util.ArrayList;
import java.util.List;

public class Computadora {

    private Sexo sexo;
    private Hobby hobby;
    private Cabello cabello;
    private Vehiculo vehiculo;
    private Seña senia;

    private List<Ladron> baseDeDatos;


    public Computadora(List<Ladron> sospechosos){

        baseDeDatos = sospechosos;
    }

    public List<Ladron> BuscarSospechoso() {
        List<Ladron> sospechosos = new ArrayList<>();
        for (Ladron ladron: baseDeDatos) {
            if(ladron.compararLadrones(sexo, hobby, cabello, vehiculo, senia)){
                sospechosos.add(ladron);
            }
        }

        return sospechosos;
    }

    public void establecerSexo(String caracteristica) {
        //TODO
    }

    public void establecerHobby(String caracteristica) {
        //TODO
    }

    public void establecerCabello(String caracteristica) {
        //TODO
    }

    public void establecerVehiculo(String caracteristica) {
        //TODO
    }

    public void establecerSenia(String caracteristica) {
        //TODO
    }


}
