package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;

public class Ladron implements ISospechable{

    private Integer ataqueConCuchillo;
    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public Ladron(){

        //sexo = caracteristicas.get(0);
        //hobby = caracteristicas.get(1);
        //cabello = caracteristicas.get(2);
        //senia = caracteristicas.get(3);
        //vehiculo = caracteristicas.get(4);
        ataqueConCuchillo = 2;
    }

    //Operations
    public boolean Arrestar() {
        //TODO
        return true;
    }

    public void atacarConCuchillo(Reloj reloj){
        reloj.descontarhoras(ataqueConCuchillo);
        if(ataqueConCuchillo == 2){
            ataqueConCuchillo--;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }

    public void setSenia(String senia) {
        this.senia = senia;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

}
