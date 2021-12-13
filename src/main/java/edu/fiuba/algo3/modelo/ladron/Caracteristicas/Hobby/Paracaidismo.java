package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

public class Paracaidismo implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return (hobby.hobby() == "Paracaidismo");
    }

    @Override
    public String hobby() {
        return "Paracaidismo";
    }
}
