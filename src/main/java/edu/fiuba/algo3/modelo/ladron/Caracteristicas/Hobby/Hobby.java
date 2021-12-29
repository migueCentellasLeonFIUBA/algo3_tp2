package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;


import java.util.ArrayList;
import java.util.List;

public class Hobby {

    private List<String> hobbys = new ArrayList<>();
    private Integer hobbyActual;

    public Hobby() {
        hobbyActual = 0;
        hobbys.add("Sin Asignar"); //0
        hobbys.add("Alpinismo"); //1
        hobbys.add("Croquet"); //2
        hobbys.add("Musica"); //3
        hobbys.add("Natacion"); //4
        hobbys.add("Paracaidismo"); //5
        hobbys.add("Tenis"); //6
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

    public Boolean estaAsignado(){
        return hobbyActual != 0;
    }

    public String getCaracteristica(){
        return hobbys.get(hobbyActual);
    }
}
