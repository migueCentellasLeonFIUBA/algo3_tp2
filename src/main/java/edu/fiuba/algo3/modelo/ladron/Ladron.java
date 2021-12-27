package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;

import java.util.ArrayList;

public class Ladron implements ISospechable,ILadron{

    private Integer ataqueConCuchillo;
    private ISospechable sospechoso;

    public Ladron(ISospechable sospechoso){
        this.sospechoso = sospechoso;
        this.ataqueConCuchillo = 2;
    }

    public void atacarConCuchillo(Reloj reloj){
        reloj.descontarhoras(ataqueConCuchillo);
        if(ataqueConCuchillo == 2){
            ataqueConCuchillo--;
        }
    }

    @Override
    public Sospechoso comparar(ArrayList<String> caracteristicas) {
        return this.sospechoso.comparar(caracteristicas);
    }

    @Override
    public boolean arrestar() {
        return true;
    }
}
