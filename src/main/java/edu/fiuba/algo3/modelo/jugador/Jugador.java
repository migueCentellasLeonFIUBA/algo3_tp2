package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Cabello.Cabello;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby.Hobby;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Senia.Senia;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;
import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.ladron.ILadron;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.util.ArrayList;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Reloj reloj;
    private GradoPolicia grado;
    private Caso caso;
    private Mapa mapa;
    private Juego juego;

    //caracteristicas computadora
    private Cabello cabello;
    private Hobby hobby;
    private Senia senia;
    private Sexo sexo;
    private Vehiculo vehiculo;

    public Jugador(String nombre,Integer arrestos,Reloj reloj,Mapa mapa, Juego juego){
        this.nombre=nombre;
        this.grado = new Novato();
        asignarGrado(arrestos);
        this.reloj = reloj;
        this.mapa=mapa;
        this.juego = juego;

        this.cabello = new Cabello();
        this.hobby = new Hobby();
        this.senia = new Senia();
        this.sexo = new Sexo();
        this.vehiculo = new Vehiculo();
    }

    public void viajarACiudad(Ciudad destino){
        mapa.viajarACiudad(destino, reloj, grado);
    }

    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
            this.grado = this.grado.arresto();
        }
    }

    public String visitarEdificio(Edificio edificio){
        if(reloj.tiempoTerminado()){
            terminarJuego();
        }
        String pista = mapa.visitarEdificio(edificio, this);
        return pista;
    }

    public Objeto ObjetoRobado(Map<String, ArrayList<Objeto>> objetos) {
        Objeto objeto = grado.ObtenerObjeto(objetos);
        return objeto;
    }

    public void empezarCaso(Caso caso) {
        this.caso= caso;
    }

    public String visitar(Edificio edificio) {
        return grado.obtenerPista(edificio);
    }

    public void descontarHoras(Integer horas) {
        reloj.descontarhoras(horas);
    }

    public ArrayList<Edificio> verEdificios() {
        return mapa.edificiosDeCiudadActual();
    }

    public ArrayList<Ciudad> verConexiones() {
        return mapa.posiblesDestinos();
    }

    public ArrayList<ISospechable> buscarSospechosos(){

        reloj.descontarhoras(3);
        return caso.buscarSospechosos();
    }

    public ArrayList<ISospechable> buscarSospechosos(ArrayList<String> caracteristicasBuscadas){
        reloj.descontarhoras(3);
        return caso.buscarSospechosos(caracteristicasBuscadas);
    }

    public String atrapar(ILadron ladron) {
        if(ladron.atrapar(reloj)){
            return "Ladron atrapado " + caso.revisarOrden(this);
        }else{
            return "Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio.";
        }
    }

    public void ganador() {
        grado = grado.arresto();

    }

    public void perdedor() {
    }

    public Boolean terminarJuego() {
        return reloj.tiempoTerminado();
    }

    //Metodos para la intrefaz
    public String getDescripcionCaso() {
        return caso.obtnerDescripcion();
    }

    public String diaYHora() {
        return reloj.diaYHora();
    }

    public String obtenerNombreCiudad() {
        return mapa.ciudadActual();
    }

    public String getDescripcionCiudad() {
        return mapa.descripcionCiudad();
    }

    public ArrayList<Ciudad> obtenerSiguientesDestinos() {
        return mapa.posiblesDestinos();
    }


    //"computadora interfaz"
    public void siguienteCabello() {
        caso.siguienteCabello();
    }

    public String getCabelloComputadora() {
        return caso.getCabelloComputadora();
    }

    public void siguienteHobby() {
        caso.siguienteHobby();
    }

    public String getHobbyComputadora() {
        return caso.getHobbyComputadora();
    }

    public void siguienteSenia() {
        caso.siguienteSenia();
    }

    public String getSeniaComputadora() {
        return caso.getSeniaComputadora();
    }

    public void siguienteSexo() {
        caso.siguienteSexo();
    }

    public String getSexoComputadora() {
        return caso.getSexoComputadora();
    }

    public void siguienteVehiculo() {
        caso.siguienteVehiculo();
    }

    public String getVehiculoComputadora() {
        return caso.getVehiculoComputadora();
    }

    public String rango() {
        return grado.rango();
    }

    public String orden(){
        return caso.orden();
    }

    public String nombre() {
        return nombre;
    }
}