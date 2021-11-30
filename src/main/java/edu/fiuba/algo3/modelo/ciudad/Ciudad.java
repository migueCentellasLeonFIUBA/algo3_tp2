package edu.fiuba.algo3.modelo.ciudad;


import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;

public class Ciudad{

    private Integer visitas;
    private String nombre;

    private Coordenadas coordenadas;
    private AeroPuerto aeroPuerto;
    private Banco banco;
    private Biblioteca biblioteca;
    private Estrategia estrategia;
    private Ladron ladron;

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void set(Ladron ladron) {
        this.ladron = ladron;
    }


    public void set(Estrategia estrategia) {
        this.estrategia = estrategia;
    }


    public void setCordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    
 /*
    public Edificio setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
 */

    //                          Operations                                  

    public void VisitarEdificio(Reloj reloj) {
        //TODO
    }

    public int CalcularDistancia(Ciudad destino) {
        //TODO
        return 0;
    }

    private Coordenadas obtenerUbicacion() {
        return this.coordenadas;
    }
    
}
