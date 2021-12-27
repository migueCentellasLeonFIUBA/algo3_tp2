package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.ladron.ILadron;

import java.util.ArrayList;
import java.util.Map;
import edu.fiuba.algo3.modelo.ManejoArchivos.Random;

public class SinPista implements IPista {

    private ArrayList<String> pistas;

    public SinPista() {
        pistas = new ArrayList<>();
        pistas.add("No vi a nadie con esas caracteristicas por aqui.");
        pistas.add("Lo siento, por aqui no paso nadie en todo el dia.");
        pistas.add("Nunca vi a la persona que buscas, lo siento.");
        pistas.add("Solo empleados ingresaron aqui.");
        pistas.add("Lo siento, no paso por aqui.");
    }

    @Override
    public String obtenerPistaFacil() {
        Random random = new Random();
        return random.obtenerStringRandom(pistas);
    }

    @Override
    public String obtenerPistaDificil() {
        Random random = new Random();
        return random.obtenerStringRandom(pistas);
    }

    @Override
    public String obtenerPistaMedia() {
        Random random = new Random();
        return random.obtenerStringRandom(pistas);
    }

    @Override
    public void setLadron(ILadron ladron) {

    }
}
