package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.IVisitor.VisitanteConcreto;
import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaces;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.orden.OrdenDeArresto;
import edu.fiuba.algo3.modelo.orden.OrdenSinJurisdiccion;
import edu.fiuba.algo3.modelo.orden.Ordenes;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private GradoPolicia grado;
    private Caso caso;
    private Ordenes orden;
    private Reloj reloj;
    private VisitanteConcreto visitante;

    public Jugador(String nombre,Integer arrestos){
        this.nombre=nombre;
        this.reloj = new Reloj();
        this.grado = new Novato();
        this.orden = new OrdenSinJurisdiccion();
        asignarGrado(arrestos);
        this.visitante = new VisitanteConcreto(grado);
    }

    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
            this.grado = this.grado.arresto();
        }
    }

    public void viajarACiudad(Ciudad destino){
        caso.viajarACiudad(destino, reloj, grado);
    }

    public ArrayList<String> BuscarSospechoso() {
        return caso.buscarSospechosos();
    }

    public void terminarJuego() {
        this.caso = null;
    }

    public String visitarEdificio(Edificio edificio) throws FileNotFoundException {

        String pista = caso.visitarEdificio(edificio, this);

        if(tiempoTerminado()){
            terminarJuego();
        }

        return pista;
    }

    private boolean tiempoTerminado() {
        return reloj.tiempoTerminado();
    }

    public void empezarCaso(Ladron ladron, Objeto objeto, Ciudad ciudad, Ciudades ciudades, Sospechosos sospechosos) {
        this.caso= new Caso(ladron, objeto, ciudad, ciudades, sospechosos);
    }

    public Integer horasRestantes(){
        return reloj.getHorasRestantes();
    }

    public void siguienteSexo() {caso.siguienteSexo();}

    public void siguienteHobby() {caso.siguienteHobby();}

    public void siguienteCabello() {caso.siguienteCabello();}

    public void siguienteVehiculo() {caso.siguienteVehiculo();}

    public void siguienteSenia() {caso.siguienteSenia();}

    public Objeto obtenerObjetoRandom(Objetos objetos){
        return grado.obtenerObjetoRandom(objetos);
    }


    //****Ordenes****
    public boolean arrestarLadron(Secuaces ladron){  //lo arresta cuando entra en una ciudad.
        if(orden.arrestarLadron(ladron)){
           grado = grado.arresto(); //se actual
            return true;
        }
        return false;
    }

    //metodo original...
    public ArrayList<String> buscarSospechosos(){
        return caso.buscarSospechosos();
    }

    public ArrayList<String> buscarSospechosos(ArrayList<String> caracteristicas, ArrayList<String> valores){
        if(caso.buscarSospechosos(caracteristicas, valores).size() == 1){
            //queda un solo sospechoso y debo emitir una orden de arresto...
            orden = new OrdenDeArresto();
        }
        return caso.buscarSospechosos(caracteristicas, valores);
    }

    public void cargarPistas(Pistas pistas) {
        grado.establecerPistas(pistas);
        grado.cargarPistas();
    }

    public void descontarHoras(Integer horas) {
        reloj.descontarhoras(horas);
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public String ciudadActual() {
        return caso.ciudadActual();
    }

    public String getDescripcionCaso() {
        return caso.getDescripcion();
    }

    public String getDescripcionCiudad(){
        return caso.getDescripcionCiudad();
    }

    public ArrayList<Ciudad> obtenerSiguientesDestinos(){
        return caso.obtenerSiguientesDestinos();
    }

    public String getSexoComputadora() {

        return caso.sexoComputadora();
    }

}
