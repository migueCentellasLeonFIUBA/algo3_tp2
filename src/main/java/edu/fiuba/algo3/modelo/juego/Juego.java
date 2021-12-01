package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Caso;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//JSON
import edu.fiuba.algo3.modelo.objeto.Objeto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;



public class Juego {

    private List<Ciudad> ciudades;
    private Computadora pc;
    private Caso caso;

    private Jugador jugador;

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
        
        JSONParser parser = new JSONParser();
        List<Objeto> objs = new ArrayList<Objeto>();

        try{
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

        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return objs;
    }


    public void IdentificarJugador() {
        //TODO
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
