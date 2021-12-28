
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Estrategia {

    private List<String> ciudadesEstrategia;
    private Integer indice = 0;

    public Estrategia(ArrayList<String> listaCiudades) {
        ciudadesEstrategia=listaCiudades;
    }

    public void aplicarEstrategia(Map<String, Ciudad> ciudades, Map<String, Map<String, IPista>> pistas, Ladron ladron) {


        for(String ciudadEstrategia: this.ciudadesEstrategia){

            Ciudad ciudadActual = ciudades.get(ciudadEstrategia);
            Map<String, IPista> pistasEdificios = pistas.get(siguienteCiudad());

            if (indice+1==ciudades.size()){
                //ciudadActual.cambiarDeEstado(new ConLadron());
            }else{
                // ciudadActual.cambiarDeEstado(new ConEstrategia());
            }
            ciudadActual.cambiarPistas(pistasEdificios,ladron);
        }
    }

    private String siguienteCiudad(){

        if (indice+1<this.ciudadesEstrategia.size()){
            indice+=1;
        }
        return this.ciudadesEstrategia.get(indice);
    }



}
