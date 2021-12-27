

package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.Map;

/*
    Muestra en cada turno las ciudades disponibles, la correcta junto con las 3 de conexión.
 */
public class Mapa {

    private Ciudad ciudadTurno;
    private Map<Ciudad, ArrayList<Ciudad>> conexiones;
    private Jugador jugador;

    public Mapa(Map<Ciudad, ArrayList<Ciudad>> conexiones, Jugador jugador){
        this.conexiones = conexiones;
        this.jugador = jugador;
    }

    //Se muestran las ciudades posibles a la interfaz:
    public ArrayList<Ciudad> getCiudadesDisponibles(Ciudad ciudad){
        return conexiones.get(ciudad); //se envia a la interfaz, la interfaz debe ubicarlas previamente en el mapa.
    }

    public void viajarACiudad(Ciudad destino){
        //se le envia la instancia de ciudad al jugador:
        jugador.viajarACiudad(destino);
    }
}
