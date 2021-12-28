package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.ladron.ILadron;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.LadronNulo;

import java.util.Map;

public class Pista implements IPista {
    private ILadron ladron;
    private Map<String, String> pistasDificultad;

    public Pista(Map<String, String> pistasMap, ILadron ladron) {
        this.pistasDificultad=pistasMap;
        this.ladron=ladron;
    }

    public void setLadron( ILadron ladron){
        this.ladron=ladron;
    }

    public String obtenerPistaFacil(){
        return pistasDificultad.get("facil")+ ladron.pistaDeLadron();
    }

    public String obtenerPistaDificil(){
        return pistasDificultad.get("dificil")+ ladron.pistaDeLadron();
    }

    public String obtenerPistaMedia(){
        return pistasDificultad.get("media")  + ladron.pistaDeLadron();
    }

}
