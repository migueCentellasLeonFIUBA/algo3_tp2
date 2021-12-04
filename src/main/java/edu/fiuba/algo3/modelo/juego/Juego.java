package edu.fiuba.algo3.modelo.juego;


import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {

    private List<Ciudad> ciudades;
    private List<Jugador> jugadores;
    private Computadora pc;
    private Jugador jugadorActual;

    public Juego(){
        this.jugadores = CargarJugadores();
    }

    private void setJugador(Jugador jugador) {
        this.jugadorActual = jugador;
    }

    //Operations
    private List<Jugador> CargarJugadores() {
        JSONParser parser = new JSONParser();
        List<Jugador> jugadores = new ArrayList<Jugador>();

        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Jugadores.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);

                Jugador nuevoPlayer = Jugador.crearJugador(js.get("Nombre").toString(),Integer.parseInt(js.get("Arrestos").toString()));

                jugadores.add(nuevoPlayer);
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return jugadores;
    }

    public void CargarSospechosos() {
        //TODO
    }

    public void CargarCiudades() {
        //TODO
    }

    public void CargarObjetos() {
        //TODO
    }

    public Jugador IdentificarJugador(String nombre) {

        for (Jugador jugador : jugadores)
        {
            if(jugador.compararJugador(nombre)){
                return jugador;
            }
        }

        //IF de decisión del usuario

        return Jugador.crearJugador(nombre,0);

        // Posible refactor -> return jugadores.stream().anyMatch("aaaa");;
    }



    public void TerminarJuego() {
        //TODO
    }

    public void CargarPistas() {
        //TODO
    }

    public void CrearCaso() {
        //TODO
    }

    public List<Objeto> cargarObjetos() throws Exception{
        JSONParser parser = new JSONParser();
        List<Objeto> objs = new ArrayList<Objeto>();

        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);

                Objeto obj=Objeto.crear((String) js.get("nombre"), Ciudad.crear((String) js.get("CiudadDeOrigen")));


                objs.add(obj);
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return objs;
    }


    public void crearCaso() throws Exception {
        List<Objeto> objs= this.cargarObjetos();
        Ladron ladron = Ladron.crear(Arrays.asList("Femenino","Carmen Sandiego"));

        jugadorActual.empezarCaso(Caso.crearCaso(ladron,objs.get(0)), objs.get(0).getCiudad());

    }
}
