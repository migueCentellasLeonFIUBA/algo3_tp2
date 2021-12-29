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

/*    public ArrayList<String> buscarSospechosos(){
        ArrayList<String> nombresSospechosos = new ArrayList<>();

        ArrayList<String> carateristicasComputadora = new ArrayList<>();

        carateristicasComputadora.add(this.cabello.getCaracteristica());
        carateristicasComputadora.add(this.hobby.getCaracteristica());
        carateristicasComputadora.add(this.senia.getCaracteristica());
        carateristicasComputadora.add(this.sexo.getCaracteristica());
        carateristicasComputadora.add(this.vehiculo.getCaracteristica());

        ArrayList<ISospechable> sospechosos = this.buscarSospechosos(carateristicasComputadora);

        //cargo los nombres de cada sospechoso:
        for(ISospechable sospechoso : sospechosos){
            nombresSospechosos.add(sospechoso.getNombre());
        }

        return nombresSospechosos;
    }
*/
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

    public Boolean terminarJuego() {
        return reloj.tiempoTerminado();
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

    public ArrayList<ISospechable> buscarSospechosos(){

        reloj.descontarhoras(3);
        return caso.buscarSospechosos();
    }


    //"computadora interfaz"
    public void siguienteCabello() {
        cabello.siguienteCabello();
    }

    public String getCabelloComputadora() {
        return cabello.getCaracteristica();
    }

    public void siguienteHobby() {
        hobby.siguienteHobby();
    }

    public String getHobbyComputadora() {
        return hobby.getCaracteristica();
    }

    public void siguienteSenia() {
        senia.siguienteSenia();
    }

    public String getSeniaComputadora() {
        return senia.getCaracteristica();
    }

    public void siguienteSexo() {
        sexo.siguienteSexo();
    }

    public String getSexoComputadora() {
        return sexo.getCaracteristica();
    }

    public void siguienteVehiculo() {
        vehiculo.siguienteVehiculo();
    }

    public String getVehiculoComputadora() {
        return vehiculo.getCaracteristica();
    }

    public String rango() {
        return grado.rango();
    }
}