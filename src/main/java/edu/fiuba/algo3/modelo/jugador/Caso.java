package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.*;

import java.util.ArrayList;


public class Caso {

    private Ladron ladron;
    private Computadora computadora;
    private String descripcion;
    private Objeto objetoRobado;
    private IOrden orden;

    public Caso(Computadora computadora, Ladron ladron, Objeto objeto){
        this.ladron = ladron;
        this.objetoRobado = objeto;
        this.orden = new NoOrden();
        this.computadora= computadora;
    }

    public ArrayList<ISospechable> buscarSospechosos(){
        return computadora.buscarSospechoso();
    }

    public String obtnerDescripcion(){
        String descripcionObjeto = this.obtenerDescripicionObjeto();
        String descripcionLadron = this.obtenerDescripicionLadron();
        String descripcionCasoFinal = this.obtenerDescripcionFinal();
        return (descripcionObjeto + descripcionLadron + descripcionCasoFinal);
    }

    private String obtenerDescripcionFinal() {
        String ciudadDeOrigen = objetoRobado.getCiudadDeOrigen();
        return ("Tu tarea: Rastrear al ladrón de" + ciudadDeOrigen + "a su econdite y arrestarlo!\n");
    }

    private String obtenerDescripicionLadron() {
        String sexo = ladron.obtenerSexo();
        return ("Sospechoso" + sexo + "identificado en la escena del crimen.\n");
    }

    private String obtenerDescripicionObjeto() {
        String ciudadDeOrigen = objetoRobado.getCiudadDeOrigen();
        String nombre = objetoRobado.getNombre();
        return ("Tesoro Nacional robado de " + ciudadDeOrigen + ".\n" + "El tesoro ha sido identificado como un " + nombre + "\n");
    }

    public ArrayList<ISospechable> buscarSospechosos(ArrayList<String> caracteristicasBuscadas) {
        ArrayList<ISospechable> sospechosos = computadora.BuscarSospechoso(caracteristicasBuscadas);
        if (sospechosos.size()==1){
            orden = new Orden(sospechosos.get(0));
        }
        return sospechosos;
    }

    public String revisarOrden(Jugador jugador) {
        return orden.revisarOrden(jugador);

    }
}
