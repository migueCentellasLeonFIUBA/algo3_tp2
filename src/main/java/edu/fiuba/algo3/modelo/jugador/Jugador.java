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

    public static Jugador crearJugador(String nombre,Integer arrestos)
    {
        new
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setArrestos(Integer arrestos) {
        this.arrestos = arrestos;
    } //debe hacerlo el rango
    private void setOrden(Orden orden) {
        this.orden = orden;
    }
    private void setCiudad(Ciudad ciudad) {
        this.ciudadActual = ciudad;
    }
    private void setComputadora(Computadora pc) {
        this.pc = pc;
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
