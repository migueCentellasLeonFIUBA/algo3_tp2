package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.IVisitor.VisitanteConcreto;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.io.FileNotFoundException;
import java.util.List;

public class Jugador {

    private String nombre;
    private Computadora pc;
    private Reloj reloj;
    private GradoPolicia grado;
    private Caso caso;
    private Orden orden;
    private Ciudad ciudadActual;
    private VisitanteConcreto visitante;


    public Jugador(String nombre,Integer arrestos){
        this.nombre=nombre;
        this.grado = new Novato();

        asignarGrado(arrestos);
        visitante = new VisitanteConcreto(grado);
    }

    public void setCiudadActual(Ciudad origen){
        this.ciudadActual = origen;
    }

    public void setReloj(Reloj reloj){
        this.reloj = reloj;
    }
    public void setGrado(GradoPolicia rango){this.grado = rango;}


    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
            this.grado = this.grado.arresto();
        }
    }

    public List<Edificio> mostrarEdificios() {

        return ciudadActual.mostrarEdificios();
    }

    public void viajarACiudad(Ciudad destino) {
        ciudadActual.calcularDistancia(destino, grado.calcularTiempoViaje(), reloj);
    }

    public void BuscarSospechoso() {
    }

    public void ArrestarSospechoso() {
    }

    public boolean tieneCasoAsignado(){
        return caso != null;
    }

    public void terminarJuego() {
        this.caso = null;
        this.reloj = null;
        this.ciudadActual = null;
        //refactor: no debería tener atributos sin inicializar
    }

    public boolean compararJugador(String nombre) {
        return nombre.equals(this.nombre);
    }

    public void comienzaEnCiudad(Ciudad ciudad) {
        this.ciudadActual=ciudad;
    }

    public String visitarEdificio(Edificio edificio) throws FileNotFoundException {
        String pista = ciudadActual.visitarEdificio(edificio, reloj, visitante);
        if(reloj.tiempoTerminado()){
            terminarJuego();
        }

        return pista;
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public void empezarCaso(Caso caso, Ciudad ciudad) {
        this.caso=caso;
        this.ciudadActual = ciudad;
        this.reloj= new Reloj();
    }

    public int horasRestantes(){
        return reloj.getHorasRestantes();
    }

    public void cargarPistas(Pistas pistas) {
        grado.establecerPistas(pistas);
        grado.cargarPistas();
    }
}
