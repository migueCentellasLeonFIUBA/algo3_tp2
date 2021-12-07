package edu.fiuba.algo3.modelo.jugador;



public class Reloj {

    private Integer horasRestantes = 168;
    private Integer horasPordia = 8;
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

    public void tiempoTerminado() {
        //TODO
    }
    public void descontarhoras(Integer horas){
        for (int i=0; i < horas; i+=1){
            this.descontarHora();
            sumarHoraPorDia();

            if(horasPordia >= 24){
                dormir();
            }

        }

    }

    private void descontarHora(){
        this.horasRestantes -=1;
        this.horasPordia += 1;
        this.dormir();
    }

    private void sumarHoraPorDia(){
        this.horasPordia += 1;
    }

    private void dormir() {
        if (horasPordia == 0){
            this.horasPordia = horasPordia + 8 - 24;
            this.descontarhoras(horasSueño);
        }
    }
}
