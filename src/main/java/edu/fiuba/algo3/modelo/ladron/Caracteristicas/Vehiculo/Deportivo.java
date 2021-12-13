package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

public class Deportivo implements Vehiculo{

    @Override
    public Boolean compararVehiculo(Vehiculo vehiculo) {
        return (vehiculo.vehiculo() == "Deportivo");
    }

    @Override
    public String vehiculo() {
        return "Deportivo";
    }
}
