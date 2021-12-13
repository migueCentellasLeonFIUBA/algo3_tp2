package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo;

public class Masculino implements Sexo{

    @Override
    public Boolean compararSexo(Sexo sexo) {
        return (sexo.sexo() == "Masculino");
    }

    @Override
    public String sexo() {
        return "Masculino";
    }
}
