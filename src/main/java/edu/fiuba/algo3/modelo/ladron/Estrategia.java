
package edu.fiuba.algo3.modelo.ladron;


import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.ConEstrategia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import edu.fiuba.algo3.modelo.ManejoArchivos.Random;
import edu.fiuba.algo3.modelo.ciudades.ConLadron;

public class Estrategia {

    private List<String> ciudadesEstrategia;

    public Estrategia(ArrayList<String> listaCiudades) {
        ciudadesEstrategia=listaCiudades;
    }

    public void aplicarEstrategia(Map<String, Ciudad> ciudades, Map<String, Map<String, IPista>> pistas, Ladron ladron) {
        Integer indice = 0;

        for(String ciudadEstrategia: this.ciudadesEstrategia){

            Ciudad ciudadActual = ciudades.get(ciudadEstrategia);
            Map<String, IPista> pistasEdificios = pistas.get(siguienteCiudad(indice));
            AgregarLadronAPistaRandom(pistasEdificios,ladron);

            if (indice+1==ciudades.size()){
                //ciudadActual.cambiarDeEstado(new ConLadron());
            }else{
                // ciudadActual.cambiarDeEstado(new ConEstrategia());
            }
            ciudadActual.cambiarPistas(pistasEdificios,ladron);
        }
    }

    private String siguienteCiudad(Integer indice){

        if (indice+1<this.ciudadesEstrategia.size()){
            indice+=1;
        }
        return this.ciudadesEstrategia.get(indice);
    }

    private void AgregarLadronAPistaRandom(Map<String, IPista> pistas,Ladron ladron){
        ArrayList<String> nombresEdificios = new ArrayList<>(pistas.keySet());
        Random random = new Random();
        String edificioRandom = random.obtenerStringRandom(nombresEdificios);
        IPista pista = pistas.get(edificioRandom);
        pista.setLadron(ladron);
    }

}
