package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Reloj reloj;
    private GradoPolicia grado;
    private Caso caso;
    private Mapa mapa;


    public Jugador(String nombre,Integer arrestos,Reloj reloj,Mapa mapa){
        this.nombre=nombre;
        this.grado = new Novato();
        asignarGrado(arrestos);
        this.reloj = reloj;
        this.mapa=mapa;
    }

    public void viajarACiudad(Ciudad destino){
        mapa.viajarACiudad(destino, reloj, grado);
    }

    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
            this.grado = this.grado.arresto();
        }
    }

    public void terminarJuego() {
        //refactor: no debería tener atributos sin inicializar Memento al juego
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
}
