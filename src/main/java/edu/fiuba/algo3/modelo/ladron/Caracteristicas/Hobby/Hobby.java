package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo.Sexo;

import java.util.ArrayList;
import java.util.List;

public class Hobby {

    private List<String> hobbys = new ArrayList<>();
    private Integer hobbyActual;

    public Hobby() {
        hobbyActual = 0;
        hobbys.add("Sin Asignar");
        hobbys.add("Alpinismo");
        hobbys.add("Croquet");
        hobbys.add("Musica");
        hobbys.add("Natacion");
        hobbys.add("Paracaidismo");
        hobbys.add("Tenis");


    }



    public String hobby() {
        return hobbys.get(hobbyActual);
    }

    public void siguienteHobby() {
        hobbyActual++;
        if (hobbyActual >= hobbys.size()) {
            hobbyActual = 0;
        }
    }
}
