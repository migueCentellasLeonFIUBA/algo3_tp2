package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Hobby;

import edu.fiuba.algo3.modelo.ladron.Caracteristicas.Seña.Seña;

public class Tenis implements Hobby{

    @Override
    public Boolean compararHobby(Hobby hobby) {
        return (hobby.hobby() == "Tenis");
    }

    @Override
    public String hobby() {
        return "Tenis";
    }
}
