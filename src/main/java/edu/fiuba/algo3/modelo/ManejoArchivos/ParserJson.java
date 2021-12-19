package edu.fiuba.algo3.modelo.ManejoArchivos;
import org.json.*;

import java.util.ArrayList;

public class ParserJson implements IParser{

    private JSONObject objetoFiltrado;
    private JSONObject objetoOriginal;

    public ParserJson(IGestorDeArchivos gestorDeArchivos) {
        objetoFiltrado=new JSONObject();
        objetoOriginal=new JSONObject(); //iria con texto
    }

    public void filtrar(String termino){
        objetoFiltrado=objetoOriginal.getJSONObject(termino);
    }

    public void volverAFiltrar(String termino){
        objetoFiltrado = objetoFiltrado.getJSONObject(termino);
    }

    public String pedirValor(String termino){
        return objetoFiltrado.getString(termino);
    }

    public ArrayList<String> listaDeElementos(){
        return  new ArrayList<>(objetoOriginal.keySet());
    }

    public long cantidad(){
        return objetoOriginal.keySet().size();
    }

}
