package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo;

public class VehiculoSinDefinir implements Vehiculo{

    @Override
    public Boolean compararVehiculo(Vehiculo vehiculo) {
        return true;
    }

    @Override
    public String vehiculo() {
        return "Vehiculo Sin Definir";
    }
}
