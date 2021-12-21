package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.IVisitor.VisitanteConcreto;
import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.*;
import edu.fiuba.algo3.modelo.orden.OrdenDeArresto;
import edu.fiuba.algo3.modelo.orden.Ordenes;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Caso {

    private List<Secuaz> sospechosos;
    private Ladron ladron;
    private Objeto objetoRobado;
    private Estrategia estrategia;
    private Computadora computadora;
    private Ciudad ciudadActual;
    private String descripcion;


    public Caso(Ladron ladron, Objeto objeto, Ciudad ciudad, Ciudades ciudades, Sospechosos sospechosos){
        this.ladron = ladron;
        this.objetoRobado = objeto;
        this.estrategia = objeto.crearEstrategia(ciudad, ciudades);
        this.computadora = new Computadora(sospechosos);
        this.ciudadActual = ciudad;
        this.descripcion = "Descripcion caso";
    }
/*
    public Secuaz BuscarSospechoso() {
        return new Secuaz();
    }
*/
    public ArrayList<String> buscarSospechosos(){
        return computadora.BuscarSospechoso();
    }

    public ArrayList<String> buscarSospechosos(ArrayList<String> caracteristicas,ArrayList<String> valores){
        return computadora.buscarSospechosos(caracteristicas, valores);
    }

    public void viajarACiudad(Ciudad destino, Reloj reloj, GradoPolicia grado) {
        reloj.descontarhoras(ciudadActual.calcularDistancia(destino, grado.calcularTiempoViaje()));
        ciudadActual = destino;
        //estrategia.actualizarCiudad(ciudadActual);
    }

/*
    public void viajarACiudad(Ciudad destino){
        estrategia.viajarACiudad(destino, grado, reloj);
    }
*/

    public String visitarEdificio(Edificio edificio, Jugador jugador) throws FileNotFoundException {

        return ciudadActual.visitarEdificio(edificio, jugador);
    }
/*
    public String visitarEdificio(Edificio edificio) throws FileNotFoundException {
        return estrategia.visitarEdificio(edificio, reloj, visitante);
    }
*/

    public void siguienteSexo() {computadora.siguienteSexo();}

    public void siguienteHobby() {computadora.siguienteHobby();}

    public void siguienteCabello() {computadora.siguienteCabello();}

    public void siguienteVehiculo() {computadora.siguienteVehiculo();}

    public void siguienteSenia() {computadora.siguienteSenia();}

    //si solo queda un sospechoso, se devuelve una orden automaticamente,
    //por default el Jugador tiene una "NoOrden".

    /*
    public Ordenes emitirOrden(){
        return new OrdenDeArresto(); //hardcodeado
    }
    */
    public String ciudadActual() {
        return ciudadActual.getNombre();
    }

    public ArrayList<Ciudad> obtenerSiguientesDestinos(){
        return estrategia.obtenerSiguientesDestinos();
    }

    public String getDescripcionCiudad(){
        return ciudadActual.getDescripcion();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String sexoComputadora() {
        return computadora.getSexo();
    }

}
