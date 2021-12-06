package edu.fiuba.algo3.modelo.edificios;


import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Banco implements Edificio {

    @Override
    public String visitarEdificio(String proximaCiudad, GradoPolicia grado) {
        JSONParser parser = new JSONParser();

        try{
            Object ob = parser.parse(new FileReader("src/main/java/edu/fiuba/algo3/Archivos/PistasBanco.json"));
            JSONArray array = (JSONArray) ob;

            for (Object pista: array ) {
                String ciudad = ((JSONObject)pista).get("Ciudad");
                String gradoPista = ((JSONObject)pista).get("Dificultad")
                if(ciudad == proximaCiudad && ){


            }


        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }



}

    //                          Operations
    @Override
    public void DamePista() {
        //TODO
    }
    
}
