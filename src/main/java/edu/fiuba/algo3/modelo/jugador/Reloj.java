package edu.fiuba.algo3.modelo.jugador;


public class Reloj {

    private Integer horasRestantes;
    private Integer horasPordia = 24;
    private Integer cuchilladas = 0;
    private Integer horasSueño = 8;

    public void setHorasRestantes(Integer horasRestantes) {
        this.horasRestantes = horasRestantes;
    }

    public Integer getHorasPordia() { return this.horasPordia; }
    public Integer getHorasRestantes() {
        return this.horasRestantes;
    }

    //Metodos
    public void ataqueConPistola() {
        //TODO
    }

    public void ataqueConCuchillo() {
        //la primera vez resta 2hs, luego 1h
        //TODO
    }

    public void visitarEdificio() {
        //TODO
    }

    public void tiempoTerminado() {
        //TODO
    }
    public void descontarhoras(Integer horas){
        for (int i=0; i < horas; i+=1){
            this.descontarHora();
        }
    }

    private void descontarHora(){
        this.horasRestantes -=1;
        this.horasPordia -= 1;
        this.dormir();
    }

    private void dormir() {
        if (horasPordia == 0){
            horasPordia = 24;
            this.descontarhoras(horasSueño);
        }
    }
    
}
