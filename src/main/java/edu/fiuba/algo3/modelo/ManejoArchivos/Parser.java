package edu.fiuba.algo3.modelo.ManejoArchivos;
import org.json.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Parser implements IParser{

    private JSONObject objetoFiltrado;
    private JSONObject objetoOriginal;

    public Parser(){
        objetoFiltrado=new JSONObject();
        objetoOriginal=new JSONObject();
    }

    public IParser parsear(String ruta){
        String texto = leerTextoCompleto(ruta);
        objetoFiltrado=new JSONObject();
        objetoOriginal=new JSONObject(texto);
        return this;
    }

    public void filtrar(String termino){
        objetoFiltrado=objetoOriginal.getJSONObject(termino);
    }

    public String pedirValor(String termino){
        return objetoFiltrado.getString(termino);
    }

    public ArrayList<String> pedirArreglo(String termino){
        JSONArray jsonArray= objetoFiltrado.getJSONArray(termino);
        List<String> list = StreamSupport.stream(jsonArray.spliterator(), false)
                .map(e -> (String)e)
                .collect(Collectors.toList());
        return new ArrayList<>(list);
    }

    public ArrayList<String> listaDeElementos(){
        return  new ArrayList<>(objetoOriginal.keySet());
    }

    public long cantidad(){
        return objetoOriginal.keySet().size();
    }

    private String leerTextoCompleto(String ruta){
        BufferedReader br = null;
        try {
        File file = new File(ruta);
            br = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br.lines().collect(Collectors.joining());
    }
/*
    private String AgregarTexto(String ruta,String textoNuevo)  {
        File file = new File(ruta);

        return ruta;
    }
*/
}
