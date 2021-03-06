package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.jugador.Reloj;

import java.util.ArrayList;

public class Ladron implements ISospechable,ILadron{

    private ISospechable sospechoso;

    public Ladron(ISospechable sospechoso){
        this.sospechoso = sospechoso;
    }

    @Override
    public Sospechoso comparar(ArrayList<String> caracteristicas) {
        return this.sospechoso.comparar(caracteristicas);
    }

    @Override
    public boolean arrestar() {
        return true;
    }

    @Override
    public String dameUnaPista() {
        return sospechoso.dameUnaPista();
    }

    @Override
    public String pistaDeLadron() {
        return sospechoso.dameUnaPista();
    }

    @Override
    public boolean atrapar(Reloj reloj) {
        return true;
    }

    public String obtenerSexo() {
        return sospechoso.obtenerSexo();
    }

    @Override
    public String getNombre(){
        return sospechoso.getNombre();
    }


}
