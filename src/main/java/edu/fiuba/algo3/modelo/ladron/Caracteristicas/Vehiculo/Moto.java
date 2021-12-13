package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

public class Moto implements Vehiculo{

    @Override
    public Boolean compararVehiculo(Vehiculo vehiculo) {
        return (vehiculo.vehiculo() == "Moto");
    }

    @Override
    public String vehiculo() {
        return "Moto";
    }
}
