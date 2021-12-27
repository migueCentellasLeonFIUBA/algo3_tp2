package edu.fiuba.algo3.modelo.pistas;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class PistasCiudad implements TiposPistas {

    private String nombreCiudad;
    private String dificultad;
    private String pista;

    public void PistaCiudad(Ciudad proximaCiudad, String dificultad){ //dificultad obtenida del grado.
        nombreCiudad = proximaCiudad.getNombre(); //lo guardo para encontar la clave de la pista con fachada, etc.
        this.dificultad = dificultad;
    }

    @Override
    public String getPista(){
        //obtiene la pista correspondiente a la proxima ciudad y dificultad, ver el archivo.

        //pista = fachada.getPista(nombreCiudad, dificultad);

        //fachada lee el archivo y devuelve el contenido de la clave pasada, si se modela entre
        // historia, geografia, economia, hay que usar de nuevo el metodo de filtrar y cargar mucos mas datos en el json.

        return "pista";
    }
}
