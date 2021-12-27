package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.IVisitor.VisitanteConcreto;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Computadora computadora;
    private Reloj reloj;
    private GradoPolicia grado;
    private Caso caso;
    private Orden orden;
    private CiudadNoEstrategia ciudadActual;
    private VisitanteConcreto visitante;


    public Jugador(String nombre,Integer arrestos,Orden orden){
        this.nombre=nombre;
        this.grado = new Novato();
        this.orden = orden;
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
            this.grado = this.grado.arresto();
        }
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
        //String pista = ciudadActual.visitarEdificio(edificio, reloj, visitante);
        if(reloj.tiempoTerminado()){
            terminarJuego();
        }

        return "";
    }

    public Objeto ObjetoRobado(Map<String, ArrayList<Objeto>> objetos) {
        Objeto objeto = grado.ObtenerObjeto(objetos);
        return objeto;
    }

    public void empezarCaso(Caso caso,Computadora computadora) {
        this.caso = caso;
        this.computadora = computadora;
    }

    public void viajarACiudad(Ciudad destino) {

    }
}
