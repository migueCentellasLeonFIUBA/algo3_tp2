package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.*;

import java.util.List;


public class Caso {

    private List<Secuaz> sospechosos;
    private Ladron ladron;
    private Objeto objetoRobado;
    private Estrategia estrategia;


    public Caso(Ladron ladron, Objeto objeto, Ciudad ciudad){
        this.ladron = ladron;
        this.objetoRobado = objeto;
        this.estrategia = objeto.crearEstrategia(ciudad);
    }



    public Ladron getLadron() {
        return ladron;
    }

    public Objeto getObjetoRobado() {
        return objetoRobado;
    }
    //Operations

    public Secuaz BuscarSospechoso() {
        //TODO
        return new Secuaz();
    }
    
}
