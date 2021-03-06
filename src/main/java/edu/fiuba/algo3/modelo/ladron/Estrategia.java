
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.ConEstrategia;
import edu.fiuba.algo3.modelo.ciudades.ConLadron;
import edu.fiuba.algo3.modelo.ciudades.Mapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Estrategia {

    private List<String> ciudadesEstrategia;
    private Integer indice = 0;

    public Estrategia(ArrayList<String> listaCiudades) {
        ciudadesEstrategia=listaCiudades;
    }

    public void aplicarEstrategia(Map<String, Ciudad> ciudades, Map<String, Map<String, IPista>> pistas, Ladron ladron,Mapa mapa) {

        mapa.setearCiudadActual(ciudades.get(ciudadesEstrategia.get(0)));
        for(String ciudadEstrategia: this.ciudadesEstrategia){
            Map<String, IPista> pistasEdificios;
            Ciudad ciudadActual = ciudades.get(ciudadEstrategia);
            indice+=1;
            if (indice==ciudadesEstrategia.size()){
                ciudadActual.cambiarDeEstado(new ConLadron());
                ciudadActual.aplicarLadron(ladron);
            }else if(indice < ciudadesEstrategia.size()){
                String siguienteCiudad = this.ciudadesEstrategia.get(indice);
                pistasEdificios = pistas.get(siguienteCiudad);
                ciudadActual.cambiarDeEstado(new ConEstrategia());
                ciudadActual.cambiarPistas(pistasEdificios,ladron);
            }
        }
    }

    public String getCiudadDeOrigen() {
        return ciudadesEstrategia.get(0);
    }
}
