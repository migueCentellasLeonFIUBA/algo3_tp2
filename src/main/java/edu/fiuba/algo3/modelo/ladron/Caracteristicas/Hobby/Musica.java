package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

public class Musica implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return (hobby.hobby() == "Musica");
    }

    @Override
    public String hobby() {
        return "Musica";
    }
}
