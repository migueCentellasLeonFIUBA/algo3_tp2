package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Senia.Senia;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Computadora {

    private Sexo sexo;
    private Hobby hobby;
    private Cabello cabello;
    private Vehiculo vehiculo;
    private Senia senia;

    private Sospechosos baseDeDatos;


    public Computadora(Sospechosos sospechosos) {

        sexo = new Sexo();
        hobby = new Hobby();
        cabello = new Cabello();
        vehiculo = new Vehiculo();
        senia = new Senia();
        baseDeDatos = sospechosos;
    }

    public ArrayList<String> BuscarSospechoso() {


/*        ArrayList<String> caracteristicas = new ArrayList<>();
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
        datos.add(senia.senia());
        datos.add(vehiculo.vehiculo());
*/

        List<ArrayList<String>> parametros = this.datosAsignados();
        ArrayList<String> caracteristicas = parametros.get(0);
        ArrayList<String> datos = parametros.get(1);

        return baseDeDatos.buscarSospechosos(caracteristicas, datos);

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
