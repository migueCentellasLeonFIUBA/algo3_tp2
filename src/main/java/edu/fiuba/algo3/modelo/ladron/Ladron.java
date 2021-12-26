package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.jugador.Reloj;

public class Ladron implements ISospechable{

    private Integer ataqueConCuchillo;
    private Sospechoso sospechoso;

    public Ladron(ISospechable sospechoso){
        this.sospechoso = (Sospechoso) sospechoso;
        this.ataqueConCuchillo = 2;
    }

    //Operations
    public boolean Arrestar() {
        //TODO
        return true;
    }

    public void atacarConCuchillo(Reloj reloj){
        reloj.descontarhoras(ataqueConCuchillo);
        if(ataqueConCuchillo == 2){
            ataqueConCuchillo--;
        }
    }


}
