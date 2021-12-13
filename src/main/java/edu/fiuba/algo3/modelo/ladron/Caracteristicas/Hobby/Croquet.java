package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

public class Croquet implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return (hobby.hobby() == "Croquet");
    }

    @Override
    public String hobby() {
        return "Croquet";
    }
}
