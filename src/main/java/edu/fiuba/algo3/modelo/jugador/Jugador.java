package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Secuaz;
import edu.fiuba.algo3.modelo.rangos.*;

public class Jugador {

    private String nombre;
    private Integer arrestos; //debe guardarlos el rango

    private Computadora pc;
    private Reloj reloj;

    private Novato rango; //???

    private Orden orden;

    private Ciudad ciudadActual;



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setArrestos(Integer arrestos) {
        this.arrestos = arrestos;
    } //debe hacerlo el rango
    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudadActual = ciudad;
    }
    public void setComputadora(Computadora pc) {
        this.pc = pc;
    }

    public String getNombre() {
        return this.nombre;
    }
    //                          Operations                                  

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
    
}
