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


}
