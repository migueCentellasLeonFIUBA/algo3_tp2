package edu.fiuba.algo3.modelo.Ifarcade;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;

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

    public Ciudad ObtenerRandom() {
        return null;
    }

}
