package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Senia.Senia;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.ladron.ISospechable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computadora {

    private Sexo sexo;
    private Hobby hobby;
    private Cabello cabello;
    private Vehiculo vehiculo;
    private Senia senia;

    private Map<String, ISospechable> sospechosos;


    public Computadora(Map<String, ISospechable> sospechosos) {

        this.sexo = new Sexo();
        this.hobby = new Hobby();
        this.cabello = new Cabello();
        this.vehiculo = new Vehiculo();
        this.senia = new Senia();
        this.sospechosos = sospechosos;
    }

    public ArrayList<String> BuscarSospechoso() {


        return null;
    }

    private List<ArrayList<String>> datosAsignados(){

        List<ArrayList<String>> parametros = new ArrayList<>();
        ArrayList<String> caracteristicas = new ArrayList<>();
        ArrayList<String> datos = new ArrayList<>();

        if(sexo.estaAsignado()){
            caracteristicas.add("Sexo");
            datos.add(sexo.sexo());
        }

        if(hobby.estaAsignado()){
            caracteristicas.add("Hobby");
            datos.add(hobby.hobby());
        }

        if(cabello.estaAsignado()){
            caracteristicas.add("Cabello");
            datos.add(cabello.cabello());
        }

        if(senia.estaAsignado()){
            caracteristicas.add("Senia");
            datos.add(senia.senia());
        }

        if(vehiculo.estaAsignado()){
            caracteristicas.add("Vehiculo");
            datos.add(vehiculo.vehiculo());
        }

        parametros.add(caracteristicas);
        parametros.add(datos);

        return parametros;
    }

    public void siguienteSexo() {
        sexo.siguienteSexo();
    }

    public void siguienteHobby() {
        hobby.siguienteHobby();
    }

    public void siguienteCabello() {
        cabello.siguienteCabello();
    }

    public void siguienteVehiculo() {
        vehiculo.siguienteVehiculo();
    }

    public void siguienteSenia() {
        senia.siguienteSenia();
    }


}
