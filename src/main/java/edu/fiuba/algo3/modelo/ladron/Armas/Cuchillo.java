package edu.fiuba.algo3.modelo.ladron.Armas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Reloj;

public class Cuchillo implements Arma{

    private Integer ataqueConCuchillo;

    public Cuchillo(){
        ataqueConCuchillo = 2;
    }

    @Override
    public void atacar(Jugador jugador) {
        jugador.descontarHoras(ataqueConCuchillo);
        if(ataqueConCuchillo == 2){
            ataqueConCuchillo--;
        }
    }
}
