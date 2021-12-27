package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.ladron.ILadron;

public interface IPista {

    public String obtenerPistaFacil();

    public String obtenerPistaDificil();

    public String obtenerPistaMedia();

    public void setLadron(ILadron ladron);
}
