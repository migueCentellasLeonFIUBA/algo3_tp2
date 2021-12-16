package edu.fiuba.algo3.modelo.jugador;

public class Reloj {

    private Integer horasRestantes;
    private Integer horaDeldia;
    private Integer horasSueño;
    private Integer horasPorDia;

    public Reloj() {
        this.horasRestantes = 168;
        this.horaDeldia = 8;
        this.horasSueño = 8;
        this.horasPorDia = 24;
    }

    public void setHorasRestantes(Integer horasRestantes) {
        this.horasRestantes = horasRestantes;
    }


    public Integer getHorasRestantes() {
        return this.horasRestantes;
    }


    public boolean tiempoTerminado () {
            return (this.horasRestantes <= 0);
        }


        public void descontarhoras (Integer horas){
            for (int i = 0; i < horas; i += 1) {
                this.descontarHora();
            }
        }

        private void descontarHora () {
            this.horasRestantes -= 1;
            this.horaDeldia += 1;
            this.dormir();
        }

        private void dormir () {
            if (horaDeldia > 23) {
                horaDeldia = horaDeldia + horasSueño - horasPorDia;
                horasRestantes = horasRestantes - horasSueño;
            }
        }

}

