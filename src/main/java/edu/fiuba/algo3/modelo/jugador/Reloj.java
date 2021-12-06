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

    public Reloj(){
        this.horasRestantes = 152;
        this.horasPordia = 24;
        this.cuchilladas = 0;
    }

    public void ataqueConPistola() {
        //TODO
    }

    public void ataqueConCuchillo() {
        if (cuchilladas == 0){
            this.horasRestantes -= 2;
            this.cuchilladas = 1;
        }
        else this.horasRestantes = -1;
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

    public void dormir() {
        this.horasRestantes -= 8;
    }
    
}
