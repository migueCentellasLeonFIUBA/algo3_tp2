package edu.fiuba.algo3.modelo.ladron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;

public class Cualidades {

    public Map<String,String> explicacionPista;
    public ArrayList<String> caracteristicas;
    public ArrayList<String> caracteristicasUsadas;

    public Cualidades(ArrayList<String> caracteristicas){
        this.caracteristicas = caracteristicas;
        this.caracteristicasUsadas= new ArrayList<>();
        caracteristicasUsadas.add(caracteristicas.get(0));
        this.explicacionPista = new HashMap<>();
        this.explicacionPista.put("Tenis"," Vino con una raqueta de Tenis.");
        this.explicacionPista.put("Croquet"," Lo escuche decir que es un gran jugador de Croquet.");
        this.explicacionPista.put("Negro"," Tenía un largo cabello Negro.");
        this.explicacionPista.put("Rojo", " Tenía un colorido cabello Rojo");
        this.explicacionPista.put("Joyas", " Poseía unas Joyas extravagantes.");
        this.explicacionPista.put("Tatuaje", " Le vi un extraño Tatuaje negro.");
        this.explicacionPista.put("Limusina", " Andaba en una lujosa Limusina.");
        this.explicacionPista.put("Deportivo", " Manejaba un bellisimo Deportivo.");
    }

    public boolean comparar(ArrayList<String> caracteristicasABuscar){

        boolean esSospechoso = true;

        for(String caracteristica : caracteristicasABuscar) {
            if (caracteristica != "Sin Asignar") {
                esSospechoso = !(caracteristicas.contains(caracteristica));
            }
        }

        return esSospechoso;
    }

    public String dameUnaPista(){
        if(caracteristicasUsadas.size()==caracteristicas.size()){
            return "";
        }
        Randomizador random = new Randomizador();

        String caracteristicaRandom = random.obtenerStringRandom(caracteristicas);
        while(caracteristicasUsadas.contains(caracteristicaRandom)){
            caracteristicaRandom = random.obtenerStringRandom(caracteristicas);
        }
        return this.explicacionPista.get(caracteristicaRandom);
    }

    public String obtenerSexo() {
        return caracteristicas.get(0);
    }
}
