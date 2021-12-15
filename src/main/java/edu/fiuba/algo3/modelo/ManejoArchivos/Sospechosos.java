package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorLadronConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorLadron;
import edu.fiuba.algo3.modelo.ladron.Ladron;

import java.util.ArrayList;

public class Sospechosos extends Archivo {

    public Sospechosos(String texto) {
        super(texto);
    }

    public ArrayList<String> buscarSospechosos(ArrayList<String> terminos,ArrayList<String> valores){
        ArrayList<String> nombres = listaDeElementos();
        ArrayList<String> resultado = new ArrayList<>();
        int indice =0;
        for(String n: nombres){
            filtrar(n);
            for(String termino: terminos){
                String valorA=pedirValor(termino);
                if(valorA==valores.get(indice)){
                    indice++;
                    continue;
                }
                break;
            }
            if(indice==valores.size()){
                resultado.add(n);
            }
            indice=0;
            removerFiltros();
        }
        return resultado;
    }

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

}
