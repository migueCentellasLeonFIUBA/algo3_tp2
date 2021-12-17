package edu.fiuba.algo3.modelo.jugador;

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

    public Jugador(String nombre,Integer arrestos){
        this.nombre=nombre;
        this.grado = new Novato();
        this.orden = new OrdenSinJurisdiccion();
        asignarGrado(arrestos);
    }

    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
            this.grado = this.grado.arresto();
        }
    }

    public void viajarACiudad(Ciudad destino){
        caso.viajarACiudad(destino);
    }

    public ArrayList<String> BuscarSospechoso() {
        return caso.buscarSospechosos();
    }

    public void terminarJuego() {
        this.caso = null;
    }

    public String visitarEdificio(Edificio edificio) throws FileNotFoundException {

        String pista = caso.visitarEdificio(edificio);
        if(caso.tiempoTerminado()){
            terminarJuego();
        }

        return pista;
    }


    public void empezarCaso(Ladron ladron, Objeto objeto, Ciudad ciudad, Ciudades ciudades, Sospechosos sospechosos) {
        this.caso= new Caso(ladron, objeto, ciudad, ciudades, sospechosos, grado);
    }

    public Integer horasRestantes(){
        return caso.horasRestantes();
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
    public boolean arrestarLadron(Secuaces ladron){
        return orden.arrestarLadron(ladron);
    }



    public void cargarPistas(Pistas pistas) {
        grado.establecerPistas(pistas);
        grado.cargarPistas();
    }
}
