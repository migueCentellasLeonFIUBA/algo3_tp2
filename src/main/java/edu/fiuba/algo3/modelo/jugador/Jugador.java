package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.util.List;

public class Jugador {

    private String nombre;
    private Integer arrestos; //debe guardarlos el rango

    private Computadora pc;
    private Reloj reloj;

    private Novato rango; //???
    private GradoPolicia grado;
    private Caso caso;

    private Orden orden;

    private Ciudad ciudadActual;


    private Jugador(String nombre,Integer arrestos){
        this.nombre=nombre;
        this.arrestos=arrestos;
        this.reloj= new Reloj();
    }

    public static Jugador crearJugador(String nombre,Integer arrestos)
    {
        return new Jugador(nombre,arrestos);
    }

    public String getNombre(){
        return this.nombre;
    }

    public Integer getArrestos(){
        return this.arrestos;
    }

    public void VisitarEdificio() {
        ciudadActual.VisitarEdificio(reloj); //estaba
    }

    public List<Edificio> mostrarEdificios() {

        return ciudadActual.mostrarEdificios();
    }

    public void viajarACiudad(Ciudad destino) {

    }

    public void BuscarSospechoso() {
    }

    public void ArrestarSospechoso() {
    }

    public void TerminarJuego() {
    }

    public boolean compararJugador(String nombre) {
        return nombre.equals(this.nombre);
    }

    public void comienzaEnCiudad(Ciudad ciudad) {
        this.ciudadActual=ciudad;
    }

    public String visitarEdificio(Edificio edificio) {

        return ciudadActual.visitarEdificio(edificio, reloj, grado);
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public void empezarCaso(Caso caso, Ciudad ciudad) {
        this.caso=caso;
        this.ciudadActual = ciudad;
    }

    public int horasRestantes(){
        return reloj.getHorasRestantes();
    }
}
