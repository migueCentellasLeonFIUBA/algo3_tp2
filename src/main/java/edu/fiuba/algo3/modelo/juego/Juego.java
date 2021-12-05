package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//JSON
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.json.*;

import java.io.FileReader;
import java.io.IOException;


import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/*
        <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
        </dependency>
 */

public class Juego {

    private List<Ciudad> ciudades;
    private Computadora pc;
    private Caso caso;
    private Jugador jugador;

    private List<Jugador> jugadores = new ArrayList<>();

    //borrar
    private String comun = "Comun";
    private String valioso = "Valioso";
    private String muyValioso = "Muyalioso";

    public Juego() throws IOException, ParseException {

    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    //Operations
    public void CargarSospechosos() {
        //TODO
    }

    public void CargarCiudades() {
        //TODO
    }

    public List<Objeto> cargarObjetos() throws Exception{

        //JSONObject objs = new JSONObject(tokener); //los paso a objetos
        List<Objeto> objs = new ArrayList<Objeto>();

        try{
            String dir = "src/main/java/edu/fiuba/algo3/Archivos/Objetos.json";
            URI direccion = new URI(dir); //abro el archivo

            //String content = new String(Files.readAllBytes(Paths.get(direccion)));
            //JSONTokener jt = new JSONTokener(new FileReader(new File("file/test.json")));
            //JSONTokener tokener = new JSONTokener(direccion.toURL().openStream()); //leo todos los objetos

            JSONTokener tokener = new JSONTokener(new FileReader(dir));
            //JSONArray array = CDL.rowToJSONArray(tokener);  //los paso a lista
            /*
                JSONObject jo3 = (JSONObject)jt.nextValue();
                System.out.println("jsonFile:"+jo3.toString());
             */

            JSONArray ja = (JSONArray) (tokener.nextValue());
            JSONObject js = (JSONObject) ja.get(0);

            Objeto obj = new Objeto();
            obj.setnombre((String) js.get("Nombre"));
            obj.setCiudad((String) js.get("CiudadDeOrigen"));
            obj.setClase((String) js.get("Rareza"));
            objs.add(obj);

            /*
            for (int i = 0; i < array.length(); i++) {

                JSONObject js = (JSONObject) array.get(i);

                Objeto obj = new Objeto();
                obj.setnombre((String) js.get("Nombre"));
                obj.setCiudad((String) js.get("CiudadDeOrigen"));
                obj.setClase((String) js.get("Rareza"));

                objs.add(obj);
            }
            */

            /*
            JSONParser parser = new JSONParser();
            List<Objeto> objs = new ArrayList<Objeto>();

            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json"));
            JSONArray array = (JSONArray) ob;

            for (int i = 0; i < array.size(); i++) {
                JSONObject js = (JSONObject) array.get(i);

                Objeto obj = new Objeto();
                obj.setnombre((String) js.get("Nombre"));
                obj.setCiudad((String) js.get("CiudadDeOrigen"));
                obj.setClase((String) js.get("Rareza"));

                objs.add(obj);
            }
        */

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return objs;
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
    
}
