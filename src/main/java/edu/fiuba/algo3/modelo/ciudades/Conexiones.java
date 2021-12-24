package edu.fiuba.algo3.modelo.ciudades;

import java.util.ArrayList;

//conserva la lista de conexiones de la ciudad actual.
public class Conexiones {
    private ArrayList<Ciudad> conexiones;

    public Conexiones(){
        conexiones = new ArrayList<>();
    }

    //recibe 3 ciudades de conexion.
    public void setConexiones(Ciudad ciudad){
        conexiones.add(ciudad);
    }

    public ArrayList<Ciudad> getCiudadesConexion(){
        return conexiones; //ver como mejorar con comportamiento.
    }
}
