package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.IBuilder.ConstructorLadronConcreto;
import edu.fiuba.algo3.IBuilder.DirectorLadron;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.ladron.Ladron;

import java.util.ArrayList;

public class Sospechosos extends Archivo {

    public Sospechosos(String texto) {
        super(texto);
    }

    public String ObtenerPista(Edificio edificio){
        return pedirValor("");
    }

    public String PistasDeCiudad(Edificio Banco){
        return pedirValor("Banco");
    }

    public Ladron ObtenerLadronRandom() {
        ArrayList<String> nombres = listaDeElementos();
        Random random = new Random();
        int posicionRandom =  random.obtenerNumeroRandom(nombres);
        filtrar(nombres.get(posicionRandom));

        ConstructorLadronConcreto constructor = new ConstructorLadronConcreto();
        DirectorLadron director = new DirectorLadron();
        director.setConstructorLadron(constructor);
        director.construirLadron(super.fachada, nombres.get(0));

        return (director.getLadron());
    }

}
