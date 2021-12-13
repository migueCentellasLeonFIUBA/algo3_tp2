package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo;

public class Femenino implements Sexo{

    @Override
    public Boolean compararSexo(Sexo sexo) {
        return (sexo.sexo() == "Femenino");
    }

    @Override
    public String sexo() {
        return "Femenino";
    }
}
