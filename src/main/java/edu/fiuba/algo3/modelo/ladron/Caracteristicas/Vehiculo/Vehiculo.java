package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo{

    private List<String> vehiculos = new ArrayList<>();
    private Integer vehiculoActual;

    public Vehiculo(){
        vehiculoActual = 0;
        vehiculos.add("Sin Asignar");
        vehiculos.add("Moto");
        vehiculos.add("Limusina");
        vehiculos.add("Deportivo");
        vehiculos.add("Descapotable");

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
}
