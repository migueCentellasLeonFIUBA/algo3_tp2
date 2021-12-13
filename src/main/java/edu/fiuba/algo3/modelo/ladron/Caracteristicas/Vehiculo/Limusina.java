package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

public class Limusina implements Vehiculo{

    @Override
    public Boolean compararVehiculo(Vehiculo vehiculo) {
        return (vehiculo.vehiculo() == "Limusina");
    }

    @Override
    public String vehiculo() {
        return "Limusina";
    }
}
