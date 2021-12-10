package edu.fiuba.algo3.modelo.juego;


import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ConstructorLadronConcreto;
import edu.fiuba.algo3.modelo.ladron.DirectorLadron;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//JSON


//import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Juego {

    private List<Ladron> ladrones = new ArrayList<>();
    private List<Objeto> objs = new ArrayList<>();
    private List<Ciudad> ciudades = new ArrayList<>();
    private List<Jugador> jugadores = new ArrayList<>();
    private Jugador jugadorActual;

    public Juego() throws Exception {

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

        ConstructorLadronConcreto constructor = new ConstructorLadronConcreto();
        DirectorLadron director = new DirectorLadron();
        director.setConstructorLadron(constructor);

        JSONParser parser = new JSONParser();
        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {

                JSONObject js = (JSONObject) array.get(i);
                director.construirLadron(js);
                Ladron ladron = director.getLadron();
                ladrones.add(ladron);

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
                this.jugadorActual = jugador;
                return jugador;
            }
        }

        //IF de decisión del usuario
        this.jugadorActual = Jugador.crearJugador(nombre, 0);

        return (this.jugadorActual);

        // Posible refactor -> return jugadores.stream().anyMatch("aaaa");;
    }



    public void TerminarJuego() {
        //TODO
    }

    public void CargarPistas() {
        //TODO
    }

    public void crearCaso() throws Exception {

        Random rand = new Random();

        Ladron ladronRandom = ladrones.get(rand.nextInt(ladrones.size()));
        Ciudad ciudadRandom = ciudades.get(rand.nextInt(ciudades.size()));
        Objeto objetoRandom = objs.get(rand.nextInt(objs.size()));

        jugadorActual.empezarCaso(Caso.crearCaso(ladronRandom, objetoRandom, ciudadRandom), ciudadRandom);

    }

    public void cargarObjetos() throws Exception{
        JSONParser parser = new JSONParser();

        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);

                String rareza = (String) (js.get("Rareza"));
                String nombre = (String) (js.get("Nombre"));

                Objeto obj=Objeto.crear(nombre, rareza);


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

    public List<Objeto> getObjetos(){
        return objs;
    }

    public Ladron getLadronActual() {
        return ladrones.get(0);
    }
}
