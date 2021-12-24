package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;

/*
    Muestra en cada turno las ciudades disponibles, la correcta junto con las 3 de conexión.
    El mapa es el encargado de pasarle la ciudad al jugador, para que este haga el viaje.
 */
public class Mapa {

    private ArrayList<Ciudad> ciudadesTurno = new ArrayList<>();
    private CiudadesMapa ciudades;

    public Mapa(CiudadesMapa ciudades){
        this.ciudades = ciudades;
    }

    //dada una ciudad, la carga, junto con sus conexiones:
    public void cargarCiudades(Ciudad ciudad){

        //primero carga la ciudad:
        this.setCiudadPosible(ciudad);

        //carga las conexiones:
        for (Ciudad conexion : ciudad.getConexiones().getCiudadesConexion()){
            this.setCiudadPosible(conexion);
        }
    }

    //se carga una ciudad posible del turno.
    private void setCiudadPosible(Ciudad ciudadPosible){
        ciudadesTurno.add(ciudadPosible);
        //la primera es siempre la indicada, las otras se obtienen por Conexiones de ciudad.
    }

    //Se muestran las ciudades posibles:
    public ArrayList<String> getCiudadesDisponibles(){
        ArrayList<String> nombreCiudades = new ArrayList<>();

        for (Ciudad ciudad : ciudadesTurno){
            nombreCiudades.add(ciudad.getNombre());
        }
        return nombreCiudades; //se envia a la interfaz, la interfaz debe ubicarlas previamente en el mapa.
    }

    //Se obtiene la ciudad para pasarsela al jugador y que este haga el viaje.
    public Ciudad getCiudad(String nombre){
        return ciudades.getCiudad(nombre); //devuelve la instancia correcta de ciudad.
    }
}
