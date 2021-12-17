package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorCiudadConcreta;
import edu.fiuba.algo3.modelo.IBuilder.DirectorCiudad;
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

    public int ObtenerPosicionCiudadRandom() {
        ArrayList<String> nombres = listaDeElementos();
        Random random = new Random();

        return (random.obtenerNumeroRandom(nombres));

    }

    public ArrayList<Ciudad> crearCiudades() {
        ArrayList<String> nombres = listaDeElementos();
        ArrayList<Ciudad> ciudades = new ArrayList<>();

        ConstructorCiudadConcreta constructor = new ConstructorCiudadConcreta();
        DirectorCiudad director = new DirectorCiudad();
        director.setConstructorCiudad(constructor);

        for(String nombre: nombres){
            director.construirCiudad(super.fachada, nombre);
            ciudades.add(director.getCiudad());
        }

        return ciudades;
    }
}
