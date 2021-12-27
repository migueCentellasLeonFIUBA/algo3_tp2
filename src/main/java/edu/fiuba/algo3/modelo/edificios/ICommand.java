package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;

public interface ICommand {
    IEdificio crear(IPista pista);
}
