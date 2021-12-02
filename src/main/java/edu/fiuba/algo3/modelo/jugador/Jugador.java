package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.rangos.Novato;

public class Jugador {

    private String nombre;
    private Integer arrestos; //debe guardarlos el rango

    private Computadora pc;
    private Reloj reloj;

    private Novato rango; //???

    private Orden orden;

    private Ciudad ciudadActual;

    private Jugador(String nombre,Integer arrestos){
        this.nombre=nombre;
        this.arrestos=arrestos;
    }

    public static Jugador crearJugador(String nombre,Integer arrestos)
    {
        return new Jugador(nombre,arrestos);
    }

    public String getNombre(){
        return this.nombre;
    }

    public Integer getArrestos(){
        return this.arrestos;
    }

    public void visitarEdificio() {
        //TODO
    }

    public void viajarACiudad(Ciudad destino) {
        //TODO
    }

    public void BuscarSospechoso() {
        //TODO
    }

    public void ArrestarSospechoso() {
        //TODO
    }

    public void TerminarJuego() {
        //TODO
    }

    public boolean compararJugador(String nombre) {
        return nombre.equals(this.nombre);
    }
}
