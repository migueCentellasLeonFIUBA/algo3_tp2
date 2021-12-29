package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo{

    private List<String> vehiculos = new ArrayList<>();
    private Integer vehiculoActual;

    public Vehiculo(){
        vehiculoActual = 0;
        vehiculos.add("Sin Asignar"); //0
        vehiculos.add("Moto"); //1
        vehiculos.add("Limusina"); //2
        vehiculos.add("Deportivo"); //3
        vehiculos.add("Descapotable"); //4

    }

    public Boolean compararVehiculo(Vehiculo vehiculo){
        return (vehiculo.vehiculo() == this.vehiculo());
    }


    public String vehiculo(){
        return vehiculos.get(vehiculoActual);
    }

    public void siguienteVehiculo(){
        vehiculoActual++;
        if(vehiculoActual >= vehiculos.size()){
            vehiculoActual = 0;
        }

    }

    public Boolean estaAsignado(){
        return vehiculoActual != 0;
    }

    public String getCaracteristica(){
        return vehiculos.get(vehiculoActual);
    }
}
