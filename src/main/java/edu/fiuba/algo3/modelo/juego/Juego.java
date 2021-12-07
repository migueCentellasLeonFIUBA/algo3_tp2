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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {

    private List<Ladron> ladrones;
    private List<Objeto> objs;
    private List<Ciudad> ciudades;
    private List<Jugador> jugadores;
    private Computadora pc;
    private Jugador jugadorActual;

    public Juego(){

        cargarJugadores();
        cargarCiudades();
        cargarSospechosos();
        cargarObjetos();
    }

    private void setJugador(Jugador jugador) {
        this.jugadorActual = jugador;
    }

    //Operations
    private void cargarJugadores() {
        JSONParser parser = new JSONParser();


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

    }

    public void cargarSospechosos() {
        JSONParser parser = new JSONParser();


        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);
                List<String> caracteristicas = new ArrayList<>();

                caracteristicas.add(js.get("Nombre").toString());
                caracteristicas.add(js.get("Sexo").toString());
                caracteristicas.add(js.get("Hobby").toString());
                caracteristicas.add(js.get("Cabello").toString());
                caracteristicas.add(js.get("Seña").toString());
                caracteristicas.add(js.get("Vehiculo").toString());

                Ladron nuevoLadron = Ladron.crear(caracteristicas);


                ladrones.add(nuevoLadron);
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarCiudades() {
        JSONParser parser = new JSONParser();

        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);

                Ciudad ciudad=Ciudad.crear((String) js.get("Ciudad"));

                ciudades.add(ciudad);
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }



    public Jugador IdentificarJugador(String nombre) {

        for (Jugador jugador : jugadores)
        {
            if(jugador.compararJugador(nombre)){
                return jugador;
            }
        }

        //IF de decisión del usuario

        return Jugador.crearJugador(nombre, 0);

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

    public void cargarObjetos() throws Exception{
        JSONParser parser = new JSONParser();

        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);

                Objeto obj=Objeto.crear((String) js.get("nombre"));


                objs.add(obj);

            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }


    public void crearCaso() {

        jugadorActual.empezarCaso(Caso.crearCaso(ladrones.get(0),objs.get(0)), ciudades.get(0));

    }

}
