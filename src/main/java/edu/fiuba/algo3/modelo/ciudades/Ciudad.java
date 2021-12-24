package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.pistas.Pista;

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
    private Conexiones ciudadesConectadas;

    public Ciudad(){
        listaEdificios = new ArrayList<>();
        this.visitas = 0;
        ladron = new nullLadron();
        descripcion = "Descripcion ciudad";
        ciudadesConectadas = new Conexiones();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setProximaCiudad(Ciudad proximaCiudad){
        this.proximaCiudad = proximaCiudad.getNombre();
    } //No se usa mas.

    public void setCiudadConexion(Ciudad conexion){
        ciudadesConectadas.setConexiones(conexion);
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

    public Conexiones getConexiones(){
        return ciudadesConectadas;
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

    public Pista visitarEdificio(Edificio edificio, Jugador jugador) throws FileNotFoundException {

        if(visitas < 3){
            visitas += 1;
        }

        ladron.atacar(jugador);

        jugador.descontarHoras(visitas);
        return edificio.aceptar(jugador);
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
