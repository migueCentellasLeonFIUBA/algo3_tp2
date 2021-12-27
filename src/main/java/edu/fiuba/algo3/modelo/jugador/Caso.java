package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.*;


public class Caso {

    private Ladron ladron;
    String descripcion;//se genera con el objeto pidiendole a la ciudad.
    private Objeto objetoRobado;//No hace falta
    private Estrategia estrategia;

    public Caso(Objeto objetoRobado, Ladron ladron) {
        this.ladron = ladron;
        this.objetoRobado = objetoRobado;


    }

    /*

        public Caso(Ladron ladron, Objeto objeto, Ciudad ciudad, Ciudades ciudades){
            this.ladron = ladron;
            this.objetoRobado = objeto;
            this.estrategia = objeto.crearEstrategia(ciudad, ciudades);
        }

    */

    public ArrayList<String> buscarSospechosos(){
        return computadora.BuscarSospechoso();
    }

    public ArrayList<String> buscarSospechosos(ArrayList<String> caracteristicas,ArrayList<String> valores){
        return computadora.buscarSospechosos(caracteristicas, valores);
    }

    public void siguienteSexo() {computadora.siguienteSexo();}

    public void siguienteHobby() {computadora.siguienteHobby();}

    public void siguienteCabello() {computadora.siguienteCabello();}

    public void siguienteVehiculo() {computadora.siguienteVehiculo();}

    public void siguienteSenia() {computadora.siguienteSenia();}

    public String getDescripcion() {
        return descripcion;
    }

    public String sexoComputadora() {
        return computadora.getSexo();
    }

    public String cabelloComputadora() {return computadora.getCabello();}

    public String hobbyComputadora() {return computadora.getHobby();}

    public String vehiculoComputadora() {return computadora.getVehiculo();}

    public String seniaComputadora() {return computadora.getSenia();}


}
