package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.jugador.Reloj;

public class LadronNulo implements ILadron{
    private Integer ataqueConCuchillo;

    public LadronNulo(){
        this.ataqueConCuchillo=2;
    }

    @Override
    public String pistaDeLadron() {
        return "";
    }

    @Override
    public boolean atrapar(Reloj reloj) {
        reloj.descontarhoras(ataqueConCuchillo);
        if(ataqueConCuchillo == 2){
            ataqueConCuchillo--;
        }
        return false;
    }
}
