package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.IVisitor.VisitanteConcreto;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
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
    private CiudadNoEstrategia ciudadActual;
    private VisitanteConcreto visitante;


    public Jugador(String nombre,Integer arrestos){
        this.nombre=nombre;
        this.grado = new Novato();

        asignarGrado(arrestos);
        visitante = new VisitanteConcreto(grado);
    }

    public void setCiudadActual(CiudadNoEstrategia origen){
        this.ciudadActual = origen;
    }

    public void setReloj(Reloj reloj){
        this.reloj = reloj;
    }
    public void setGrado(GradoPolicia rango){this.grado = rango;}


    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
        }
    }

    public List<IEdificio> mostrarEdificios() {

        return ciudadActual.mostrarEdificios();
    }

    public void viajarACiudad(CiudadNoEstrategia destino) {
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

    public void comienzaEnCiudad(CiudadNoEstrategia ciudad) {
        this.ciudadActual=ciudad;
    }

    public String visitarEdificio(IEdificio edificio) throws FileNotFoundException {
        String pista = ciudadActual.visitarEdificio(edificio, reloj, visitante);
        if(reloj.tiempoTerminado()){
            terminarJuego();
        }

        return pista;
    }

    public CiudadNoEstrategia getCiudadActual() {
        return ciudadActual;
    }

    public void empezarCaso(Caso caso, CiudadNoEstrategia ciudad) {
        this.caso=caso;
        this.ciudadActual = ciudad;
        this.reloj= new Reloj();
    }

}
