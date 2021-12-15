package edu.fiuba.algo3.modelo.ManejoArchivos;


import edu.fiuba.algo3.modelo.IBuilder.ConstructorObjetoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorObjeto;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;

public class Objetos extends Archivo {

    public Objetos(String texto) {
        super(texto);
    }

    public Objeto ObtenerObjetoRandom() {

        ArrayList<String> nombres = listaDeElementos();
        Random random = new Random();
        int posicionRandom =  random.obtenerNumeroRandom(nombres);
        filtrar(nombres.get(posicionRandom)); //nombres solo se queda con los valores del nombre pasado.

        ConstructorObjetoConcreto constructor = new ConstructorObjetoConcreto();
        DirectorObjeto director = new DirectorObjeto();
        director.setConstructorObjeto(constructor);

        director.construirObjeto(super.fachada, nombres.get(0)); //el unico nombre
        //director.construirCiudad(super.fachada, nombres.get(posicionRandom)); //probar sin filtrar.

        return (director.getObjeto());
    }
}
