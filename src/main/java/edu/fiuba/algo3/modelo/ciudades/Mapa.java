

package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.util.ArrayList;
import java.util.Map;

/*
    Muestra en cada turno las ciudades disponibles, la correcta junto con las 3 de conexión.
 */
public class Mapa {

    private Ciudad ciudadActual;
    private Map<Ciudad, ArrayList<Ciudad>> conexiones;
    //private Jugador jugador;

    public Mapa(Map<Ciudad, ArrayList<Ciudad>> conexiones, Jugador jugador){
        this.conexiones = conexiones;
        //this.jugador = jugador;
    }

    //Se muestran las ciudades posibles a la interfaz:
    public ArrayList<Ciudad> getCiudadesDisponibles(Ciudad ciudad){
        return conexiones.get(ciudad); //se envia a la interfaz, la interfaz debe ubicarlas previamente en el mapa.
    }

    public void viajarACiudad(Ciudad destino, Reloj reloj, GradoPolicia grado){
        //se le envia la instancia de ciudad al jugador:
        ciudadActual.viajarACiudad(destino, reloj, grado);
    }

    public ArrayList<Ciudad> posiblesDestinos(){
        return conexiones.get(ciudadActual.nombre());
    }

    public void actualizarCiudadActual(Ciudad ciudad){
        ciudadActual = ciudad;
    }
}
