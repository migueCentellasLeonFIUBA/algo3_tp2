package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

public class Descapotable implements Vehiculo{

    @Override
    public Boolean compararVehiculo(Vehiculo vehiculo) {
        return (vehiculo.vehiculo() == "Descapotable");
    }

    @Override
    public String vehiculo() {
        return "Descapotable";
    }
}
