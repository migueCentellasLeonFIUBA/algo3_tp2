package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

public class Natacion implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return (hobby.hobby() == "Natacion");
    }

    @Override
    public String hobby() {
        return "Natacion";
    }
}
