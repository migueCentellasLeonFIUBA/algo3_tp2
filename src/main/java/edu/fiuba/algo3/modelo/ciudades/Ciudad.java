package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad{

    private String nombre;
    private Integer visitas;
    private List<Edificio> listaEdificios;
    private Coordenadas coordenadas;
    private String descripcion;
    private String proximaCiudad;
    private Secuaces ladron;

    public Ciudad(){
        listaEdificios = new ArrayList<>();
        this.visitas = 0;
        ladron = new nullLadron();
        descripcion = "Puerto Moresby, es la capital de Papúa Nueva Guinea, y su mayor aglomeración de población contando su área metropolitana que se extiende por todo el Distrito Capital Nacional. La ciudad está situada en las costas del golfo de Papúa, en la costa sureste de la isla de Nueva Guinea. Esta ciudad es considerada la ciudad más peligrosa del mundo, según un informe presentado por el programa de la ONU para los Asentamientos Humanos. Puerto Moresby tiene un clima tropical húmedo y seco con temperaturas relativamente constantes todo el año.TM";
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setProximaCiudad(Ciudad proximaCiudad){
        this.proximaCiudad = proximaCiudad.getNombre();
    }


    public void setCoordenadas(String latitud, String longitud) {
        this.coordenadas = new Coordenadas(Double.parseDouble(latitud), Double.parseDouble(longitud));
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }


    public List<Edificio> mostrarEdificios(){
        List <Edificio> copiaListaEdificios = listaEdificios.stream().collect(Collectors.toList());
        return copiaListaEdificios;
    }

    public Integer calcularDistancia(Ciudad destino, Integer velocidad) {
       double distanciaKm = coordenadas.calcularDistancia(destino.getUbicacion());
       int horas = (int) distanciaKm / velocidad;
       if (horas == 0) horas +=1;
       return horas;
    }

    private Coordenadas getUbicacion() {
        return coordenadas;
    }

    public String visitarEdificio(Edificio edificio, Jugador jugador) throws FileNotFoundException {

        if(visitas < 3){
            visitas += 1;
        }

        ladron.atacar(jugador);

        jugador.descontarHoras(visitas);
        Visitante visitante = jugador.getVisitante();
        visitante.filtrarCiudad(proximaCiudad);
        return edificio.aceptar(visitante);
    }

    public Edificio obtenerEdificio(int i) {
        return listaEdificios.get(i);
    }

    public void setLadron(Ladron ladronActual){
        ladron = ladronActual;
    }


    public String getNombre(){
        return this.nombre;
    }

    public boolean esLaMismaCiudad(Ciudad ciudad){
        return this.nombre.equals(ciudad.getNombre());
    }

    public boolean esLaMismaCiudad(String nombre){
        return this.nombre.equals(nombre);
    }

}
