package edu.fiuba.algo3.modelo.ciudades;

import java.util.ArrayList;

//conserva la lista de conexiones de la ciudad actual.
//limita la cantidad de conexiones a "3".
public class Conexiones {
    private ArrayList<Ciudad> conexiones;

    public Conexiones(){
        conexiones = new ArrayList<>();
    }

    //recibe 3 ciudades de conexion.
    public void setConexiones(Ciudad ciudad){
        if(this.faltanConexiones()){
            conexiones.add(ciudad);
        }
    }

    private Boolean faltanConexiones(){
        return (3 > conexiones.size());
    }

    public ArrayList<Ciudad> getCiudadesConexion(){
        return conexiones; //ver como mejorar con comportamiento, se usa en mapa.cargarCiudades().
    }
}
