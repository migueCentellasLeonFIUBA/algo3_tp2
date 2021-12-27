package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.*;

import java.util.ArrayList;


public class Caso {

    private Ladron ladron;
    private Computadora computadora;
    String descripcion;//se genera con el objeto pidiendole a la ciudad.
    private Objeto objetoRobado;//No hace falta

    public Caso(Computadora computadora, Ladron ladron, Objeto objeto){
        this.ladron = ladron;
        this.objetoRobado = objeto;
        this.computadora= computadora;
    }

    public String obtnerDescripcion() {
        return "";
    }
}
