package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
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

    public Jugador(String nombre,Integer arrestos,Reloj reloj,Mapa mapa, Juego juego){
        this.nombre=nombre;
        this.grado = new Novato();
        asignarGrado(arrestos);
        this.reloj = reloj;
        this.mapa=mapa;
        this.juego = juego;
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

    public ArrayList<ISospechable> buscarSospechosos(ArrayList<String> caracteristicasBuscadas){
        reloj.descontarhoras(3);
        return caso.buscarSospechosos(caracteristicasBuscadas);
    }

    public void atrapar(ILadron ladron) {
        if(ladron.atrapar(reloj)){
            caso.revisarOrden(this);
        }
    }

    public void ganador() {
        //se suma un arresto:
        grado = grado.arresto();

        //se crea un nuevo caso:
        juego.asignarOtroCaso();
    }

    public void perdedor() {
        //se crea un nuevo caso:
        juego.asignarOtroCaso();
    }

    public void terminarJuego() {
        //refactor: no debería tener atributos sin inicializar Memento al juego

    }


    //intrefaz
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

}
