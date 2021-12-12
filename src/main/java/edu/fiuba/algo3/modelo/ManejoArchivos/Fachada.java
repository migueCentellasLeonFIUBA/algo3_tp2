package edu.fiuba.algo3.modelo.ManejoArchivos;
import org.json.*;

import java.util.ArrayList;

public class Fachada {

    private JSONObject objeto;
    private String textoOriginal;

    public Fachada(String texto) {
        objeto = new JSONObject(texto);
        textoOriginal=texto;
    }

    public void filtrar(String termino){
        objeto=objeto.getJSONObject(termino);
    }

    public String pedirValor(String termino){
        return objeto.getString(termino);
    }

    public ArrayList<String> listaDeElementos(){
        return  new ArrayList<>(objeto.keySet());
    }

    public void resetear(){
        new JSONObject(textoOriginal);
    }

    public long cantidad(){
        return objeto.keySet().size();
    }

}
