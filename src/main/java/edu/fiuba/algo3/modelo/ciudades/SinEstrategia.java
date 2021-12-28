package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Reloj;

public class SinEstrategia implements IEstado{
    @Override
    public String visitarEdificio(Edificio edificio, Jugador jugador) {
        return edificio.aceptar(jugador);
    }
    @Override
    public void agregarConexion(Mapa mapa, Ciudad ciudadAnterior){
        if(!(mapa.posiblesDestinos().contains(ciudadAnterior))){
            mapa.agregarConexion(ciudadAnterior);
        }
    }

}
