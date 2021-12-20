package edu.fiuba.algo3.modelo.ladron.Armas;

import edu.fiuba.algo3.modelo.jugador.Reloj;

public class Pistola implements Arma{

    private Integer ataqueConArma;

    public Pistola(){
        ataqueConArma = 4;
    }

    @Override
    public void atacar(Reloj reloj) {
        reloj.descontarhoras(ataqueConArma);
    }
}
