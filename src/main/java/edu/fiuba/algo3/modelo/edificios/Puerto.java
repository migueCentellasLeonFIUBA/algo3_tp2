package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.Pistas.SinPista;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ILadron;
import edu.fiuba.algo3.modelo.rangos.Detective;
import edu.fiuba.algo3.modelo.rangos.Investigador;
import edu.fiuba.algo3.modelo.rangos.Novato;
import edu.fiuba.algo3.modelo.rangos.Sargento;

import java.util.Map;


public class Puerto extends Edificio {

    public Puerto(IPista pista) {
        this.pista = new SinPista();
    }

    @Override
    public void cambiarPista(Map<String, IPista> pistasEdificios, ILadron ladron) {
        this.pista = pistasEdificios.get("Puerto");
        this.pista.setLadron(ladron);
    }
}
