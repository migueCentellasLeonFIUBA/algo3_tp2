package edu.fiuba.algo3.modelo.pistas;

public class PistasLadron implements TiposPistas{

    private String dato;
    private String descripciones;

    public PistasLadron(String pistaLadron){ //esta debe ser un tipo, tal vez se puedan usar las caracteristicas
        dato = pistaLadron;
        descripciones = "descripciones para cada carateristaca, debe ser un array.";
    }

    @Override
    public String getPista(){
        //averigua el tipo de pista recibida y devuelve un texto preprocesado correspondiente a la caracterisitca + el dato

        //el orden del seteo de las caracteriscas de ladron, es el mismo orden en el que se devuelven las pistas del ladron
        //por si no se modelan las pistas.
        return descripciones + dato;
    }

}
