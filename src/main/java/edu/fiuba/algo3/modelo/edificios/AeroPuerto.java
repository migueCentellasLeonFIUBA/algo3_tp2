package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

public class AeroPuerto implements Edificio {

    @Override
    public String visitarEdificio(String ciudad, GradoPolicia grado) {

        return "Pista Aeropuerto"; //REFACTOR NECESARIO - SE DEBE COMUNICAR CON LA FACHADA DE JSON
    }
    
}
