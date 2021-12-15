package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Senia.Senia;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;

import java.util.ArrayList;

public class Computadora {

    private Sexo sexo;
    private Hobby hobby;
    private Cabello cabello;
    private Vehiculo vehiculo;
    private Senia seña;

    private Sospechosos sospechosos;


    public Computadora(Sospechosos sospechosos) {

        sospechosos = sospechosos;
    }

    public ArrayList<String> BuscarSospechoso() {


        ArrayList<String> caracteristicas = new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");
        caracteristicas.add("Cabello");
        caracteristicas.add("Vehiculo");
        caracteristicas.add("Cabello");
        caracteristicas.add("Seña");

        ArrayList<String> datos = new ArrayList<>();
        datos.add(sexo.sexo());
        datos.add(hobby.hobby());
        datos.add(cabello.cabello());
        datos.add(seña.seña());
        datos.add(vehiculo.vehiculo());

        return sospechosos.buscarSospechosos(caracteristicas, datos);


    }

    public void siguienteSexo() {
        //TODO
    }

    public void siguienteHobby() {
        //TODO
    }

    public void siguienteCabello() {
        //TODO
    }

    public void siguienteVehiculo() {
        //TODO
    }

    public void siguienteSenia() {
        //TODO
    }


}
