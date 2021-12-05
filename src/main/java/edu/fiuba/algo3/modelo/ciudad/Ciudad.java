package edu.fiuba.algo3.modelo.ciudad;


import edu.fiuba.algo3.modelo.pistas.Pista;

import edu.fiuba.algo3.modelo.edificios.AeroPuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;

import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

public class Ciudad{

    private Integer visitas;
    private String nombre;

    private Coordenadas coordenadas;

    private AeroPuerto aeroPuerto = new AeroPuerto();
    private Banco banco = new Banco();
    private Biblioteca biblioteca;
    private Edificio edificio;

    private Estrategia estrategia;
    private Ladron ladron;
    private Pista IPista;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setLadron(Ladron ladron) {
        this.ladron = ladron;
    }


    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void setCordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }


    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }


    //                          Operations

    public void VisitarEdificio(Reloj reloj) {
        //TODO
    }

    public int calcularDistancia(Ciudad destino) {
        return coordenadas.calcularDistancia(destino.getUbicacion());
    }

    //opcion2:
    public void calcularDistancia(Ciudad destino, Integer velocidad, Reloj reloj) {
        coordenadas.calcularDistancia(destino.getUbicacion(), velocidad,reloj);
    }
    private Coordenadas getUbicacion() {
        return coordenadas;
    }

    public Pista visitarEdificio(Reloj reloj, GradoPolicia grado) {
        return IPista;
    }
}
