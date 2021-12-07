package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.pistas.Pista;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ciudad{

    private String nombre;
    private Integer visitas;
    private List<Edificio> listaEdificios;
    private Coordenadas coordenadas;
;
    private Ladron ladron;

    private String proximaCiudad;

    private Ciudad(String nombre) {

        this.visitas = 0;
        this.nombre = nombre;
        listaEdificios = new ArrayList<>();
        cargarEdificios();
    }

    private void cargarEdificios(){

        Random rand = new Random();
        List<Edificio> listaEnteraEdificios = new ArrayList<>();
        listaEnteraEdificios.add(new AeroPuerto());
        listaEnteraEdificios.add(new Banco());
        listaEnteraEdificios.add(new Biblioteca());
        listaEnteraEdificios.add(new Puerto());
        listaEnteraEdificios.add(new Bolsa());


        Integer h = 5;
        for(int i = 3; i != 0; i--){
            Integer random = rand.nextInt(h);
            listaEdificios.add(listaEnteraEdificios.get(random));
            listaEnteraEdificios.remove(random);
            h--;
        }

    }

    public void setEdificios(List<Edificio> edificios){
        listaEdificios = edificios;
    }

    public void setLadron(Ladron ladron){
        this.ladron = ladron;
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

/*
    public void set(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
*/

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

    public String visitarEdificio(Edificio edificio, Reloj reloj, GradoPolicia grado) throws FileNotFoundException {

        if(visitas < 3){
            visitas += 1;
        }

        if(ladron != null){
            ladron.atacarConCuchillo(reloj);
        }

        reloj.descontarhoras(visitas);


        return edificio.visitarEdificio(proximaCiudad, grado);
    }

    public Edificio obtenerEdificio(int i) {
        return listaEdificios.get(i);
    }
}
