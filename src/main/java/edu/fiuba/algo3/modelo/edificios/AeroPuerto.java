package edu.fiuba.algo3.modelo.edificios;


import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

public class AeroPuerto implements Edificio {

    @Override
    public String visitarEdificio(String ciudad, GradoPolicia grado) {

        return "Pista Areopuerto"; //harcodeo
    }

    //                          Operations
    @Override
    public void DamePista() {
        //TODO
    }
    
}
