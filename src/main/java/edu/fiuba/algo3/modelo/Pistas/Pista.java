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
        return pistasDificultad.get("facil");
    }

    public String obtenerPistaDificil(){
        return pistasDificultad.get("dificil");
    }

    public String obtenerPistaMedia(){
        return pistasDificultad.get("media") ;//+ ladron.obtenerPista()// Las cualidades deben saber que pistas ya dieron.
    }

    private String pistaDeLadron(){
        return null;// ladron.obtenerPista();
    }

}
