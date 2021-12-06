package edu.fiuba.algo3.modelo.ciudad;


import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad{

    private Integer visitas;
    private String nombre;

    private List<Edificio> listaEdificios;
    private Coordenadas coordenadas;
    private AeroPuerto aeroPuerto;
    private Banco banco;
    private Biblioteca biblioteca;
    private Estrategia estrategia;
    private Ladron ladron;
    private Edificio edificio;
    private Pista IPista;
    private String proximaCiudad;

    private Ciudad(String nombre) {

        this.nombre = nombre;
        cargarEdificios();
    }

    private void cargarEdificios(){
        listaEdificios = new ArrayList<>();
        listaEdificios.add(new AeroPuerto());
        listaEdificios.add(new Banco());
        listaEdificios.add(new Biblioteca());

    }

    public static Ciudad crear(String ciudadDeOrigen) {
        return new Ciudad(ciudadDeOrigen);
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

    public void set(Ladron ladron) {
        this.ladron = ladron;
    }


    public void set(Estrategia estrategia) {
        this.estrategia = estrategia;
    }


    public void setCordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Edificio> mostrarEdificios(){
        List <Edificio> copiaListaEdificios = listaEdificios.stream().collect(Collectors.toList());
        return copiaListaEdificios;
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

    public String visitarEdificio(Edificio edificio, Reloj reloj, GradoPolicia grado) {
        if(visitas < 3){
            visitas += 1;
        }

        reloj.descontarhoras(visitas);

        return edificio.visitarEdificio(proximaCiudad, grado);
    }
}
