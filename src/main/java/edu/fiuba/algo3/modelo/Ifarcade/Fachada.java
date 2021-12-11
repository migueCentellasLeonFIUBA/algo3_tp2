package edu.fiuba.algo3.modelo.Ifarcade;
import org.json.*;

import java.util.Set;

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

    public Set<String> setDeElementos(){
        return objeto.keySet();
    }

    public void resetear(){
        new JSONObject(textoOriginal);
    }

    public long cantidad(){
        return objeto.keySet().stream().count();
    }

}
