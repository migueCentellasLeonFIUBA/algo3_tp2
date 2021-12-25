package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorLadronConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorLadron;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Ladron;

import java.util.ArrayList;
import java.util.Map;

public class Sospechosos{
    Map<String, ISospechable> sospechosos;

    public ArrayList<String> buscarSospechosos(ArrayList<String> terminos,ArrayList<String> valores){
        return null;
    }
/*
    public Ladron ObtenerLadronRandom() {
        ArrayList<String> nombres = listaDeElementos();
        Random random = new Random();
        int posicionRandom =  random.obtenerNumeroRandom(nombres);
        filtrar(nombres.get(posicionRandom));

        ConstructorLadronConcreto constructor = new ConstructorLadronConcreto();
        DirectorLadron director = new DirectorLadron();
        director.setConstructorLadron(constructor);
        director.construirLadron(super.fachada, nombres.get(posicionRandom));

        return (director.getLadron());
    }
*/
}
