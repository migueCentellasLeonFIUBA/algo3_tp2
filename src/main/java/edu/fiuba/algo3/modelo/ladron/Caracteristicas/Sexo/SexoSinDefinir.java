package edu.fiuba.algo3.modelo.ladron.Caracteristicas.Sexo;

public class SexoSinDefinir implements Sexo{

    @Override
    public Boolean compararSexo(Sexo sexo) {
        return true;
    }

    @Override
    public String sexo() {
        return "Sexo Sin Definir";
    }
}
