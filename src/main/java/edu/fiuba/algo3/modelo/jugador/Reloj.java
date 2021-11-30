package edu.fiuba.algo3.modelo.jugador;



public class Reloj {

    private Integer horasRestantes;
    private Integer horasPordia;
    private Integer cuchilladas;

    public Integer getHorasRestantes() {
        return this.horasRestantes;
    }
    public void setHorasRestantes(Integer horasRestantes) {
        this.horasRestantes = horasRestantes;
    }
    public Integer getHorasPordia() {
        return this.horasPordia;
    }
    public void setHorasPordia(Integer horasPordia) {
        this.horasPordia = horasPordia;
    }

    //Metodos

    public void ataqueConPistola() {
        //TODO
    }

    public void ataqueConCuchillo() {
        //la primera vez resta 2hs, luego 1h
        //TODO
    }

    public void descontarViaje() {
        //TODO
    }

    public void visitarEdificio() {
        //TODO
    }

    public void tiempoTerminado() {
        //TODO
    }

    private void dormir() {
        //TODO
    }
    
}
