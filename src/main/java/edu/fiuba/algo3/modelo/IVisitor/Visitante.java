package edu.fiuba.algo3.modelo.IVisitor;

import edu.fiuba.algo3.modelo.edificios.*;

public interface Visitante {

    String visitar(AeroPuerto aeropuerto);

    String visitar(Banco banco);

    String visitar(Biblioteca biblioteca);

    String visitar(Bolsa bolsa);

    String visitar(Puerto puerto);

}
