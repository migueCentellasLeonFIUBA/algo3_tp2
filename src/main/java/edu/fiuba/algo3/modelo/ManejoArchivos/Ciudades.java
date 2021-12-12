package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.IBuilder.ConstructorCiudadConcreta;
import edu.fiuba.algo3.IBuilder.DirectorCiudad;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;

import java.util.ArrayList;

public class Ciudades extends Archivo {

    public Ciudades(String texto) {
        super(texto);
    }

    public String ObtenerPista(Edificio edificio){
        return pedirValor("");
    }

    public String PistasDeCiudad(Edificio Banco){
        return pedirValor("Banco");
    }

    public Ciudad ObtenerCiudadRandom() {

        ArrayList<String> nombres = listaDeElementos();
        Random random = new Random();
        int posicionRandom =  random.obtenerNumeroRandom(nombres);

        filtrar(nombres.get(posicionRandom)); //nombres solo se queda con los valores del nombre pasado.

        ConstructorCiudadConcreta constructor = new ConstructorCiudadConcreta();
        DirectorCiudad director = new DirectorCiudad();
        director.setConstructorCiudad(constructor);

        director.construirCiudad(super.fachada, nombres.get(0)); //el unico nombre
        //director.construirCiudad(super.fachada, nombres.get(posicionRandom)); //probar sin el filtro.

        return (director.getCiudad());
    }

}
