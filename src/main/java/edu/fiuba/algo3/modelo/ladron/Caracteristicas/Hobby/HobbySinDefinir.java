package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

public class HobbySinDefinir implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return true;
    }

    @Override
    public String hobby() {
        return "Hobby Sin Definir";
    }
}
