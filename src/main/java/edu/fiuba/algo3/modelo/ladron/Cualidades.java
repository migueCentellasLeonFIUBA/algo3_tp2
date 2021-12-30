package edu.fiuba.algo3.modelo.ladron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        this.explicacionPista.put("Tenis"," vino con una raqueta de Tenis.");
        this.explicacionPista.put("Croquet"," lo escuche decir que es un gran jugador de Croquet.");
        this.explicacionPista.put("Negro"," tenía un largo cabello Negro.");
        this.explicacionPista.put("Rojo", " tenía un colorido cabello Rojo");
        this.explicacionPista.put("Joyas", " poseía unas Joyas extravagantes.");
        this.explicacionPista.put("Tatuaje", " le vi un extraño Tatuaje negro.");
        this.explicacionPista.put("Limusina", " andaba en una lujosa Limusina.");
        this.explicacionPista.put("Deportivo", " manejaba un bellisimo Deportivo.");
        this.explicacionPista.put("Descapotable", ", conducía un coche descapotable clasico");
        this.explicacionPista.put("Anillo", ", tenía puesto un anillo muy lujoso");
        this.explicacionPista.put("Rubio", ", tenía el cabello rubio");
        this.explicacionPista.put("Castaño", ", tenía el cabello castaño");
        this.explicacionPista.put("Natacion", ", llevaba en su maleta unas antiparras para nadar");
        this.explicacionPista.put("Alpinismo", ", llevaba en su maleta unas botas y picos, como de alpinismo");
        this.explicacionPista.put("Moto", ", conducía una moto roja");
    }


    public boolean comparar(ArrayList<String> caracteristicasABuscar){

        boolean esSospechoso = true;

        for(String caracteristica : caracteristicasABuscar) {
            if (!caracteristica.equals("Sin Asignar")) {
                if(!(caracteristicas.contains(caracteristica))){
                    return false;
                }
            }

        }
        return esSospechoso;
    }

    public String dameUnaPista(){


        Randomizador random = new Randomizador();
        String caracteristicaRandom = random.obtenerStringRandom(caracteristicas);

        for(String caracteristica: caracteristicas){
            if (!caracteristicasUsadas.contains(caracteristicaRandom)){
                caracteristicasUsadas.add(caracteristicaRandom);
                return explicacionPista.get(caracteristicaRandom);
            }
        }

        return "";
    }

    public String obtenerSexo() {
        return caracteristicas.get(0);
    }
}
