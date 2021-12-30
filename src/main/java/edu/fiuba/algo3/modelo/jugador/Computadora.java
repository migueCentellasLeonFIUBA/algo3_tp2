package edu.fiuba.algo3.modelo.jugador;

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

    public ArrayList<ISospechable> BuscarSospechoso(ArrayList<String> caracteristicasBuscadas) {
        ArrayList<String> listaNombreSospechosos = new ArrayList<>(sospechosos.keySet());;
        ArrayList<ISospechable> listaSospechosos = new ArrayList<>();

        for(String nombre : listaNombreSospechosos){
            ISospechable sospechoso =  sospechosos.get(nombre);
            if(sospechoso.comparar(caracteristicasBuscadas)!=null){
                listaSospechosos.add(sospechoso);
            }
        }

        return listaSospechosos;
    }

    public ArrayList<ISospechable> buscarSospechoso(){
        ArrayList<String> listaNombreSospechosos = new ArrayList<>(sospechosos.keySet());;
        ArrayList<ISospechable> listaSospechosos = new ArrayList<>();
        ArrayList<String> caracteristicasBuscadas = datosAsignados();

        return BuscarSospechoso(caracteristicasBuscadas);
    }

    private ArrayList<String> datosAsignados(){

       ArrayList<String> datos = new ArrayList<>();

       if(sexo.estaAsignado()){
            datos.add(sexo.sexo());
       }

        if(hobby.estaAsignado()){
            datos.add(hobby.hobby());
        }

        if(cabello.estaAsignado()){
            datos.add(cabello.cabello());
        }

        if(senia.estaAsignado()){
            datos.add(senia.senia());
        }

        if(vehiculo.estaAsignado()){
            datos.add(vehiculo.vehiculo());
        }

        return datos;
    }

    public void siguienteSexo() {sexo.siguienteSexo();}

    public void siguienteHobby() {hobby.siguienteHobby();}

    public void siguienteCabello() {cabello.siguienteCabello();}

    public void siguienteVehiculo() {vehiculo.siguienteVehiculo();}

    public void siguienteSenia() {senia.siguienteSenia();}


    public String getSexo() {
        return sexo.sexo();
    }

    public String getCabello() {return cabello.cabello();}

    public String getVehiculo() {return vehiculo.vehiculo();}

    public String getSenia() {return senia.senia();}

    public String getHobby() {return hobby.hobby();}
}