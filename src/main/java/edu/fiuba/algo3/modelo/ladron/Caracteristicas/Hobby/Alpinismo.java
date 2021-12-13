package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

public class Alpinismo implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return (hobby.hobby() == "Alpinismo");
    }

    @Override
    public String hobby() {
        return "Alpinismo";
    }
}
