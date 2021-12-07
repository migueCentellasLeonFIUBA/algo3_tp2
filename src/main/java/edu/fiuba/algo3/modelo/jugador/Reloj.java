package edu.fiuba.algo3.modelo.jugador;

public class Reloj {

    private Integer horasRestantes;
    private Integer horasDeldia;
    private Integer horasSueño;

    public Reloj() {
        this.horasRestantes = 168;
        this.horasDeldia = 8;
        this.horasSueño = 8;
    }

    public void setHorasRestantes(Integer horasRestantes) {
        this.horasRestantes = horasRestantes;
    }


    public Integer getHorasRestantes() {
        return this.horasRestantes;
    }


        public void visitarEdificio () {
            //TODO
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
            this.horasDeldia += 1;
            this.dormir();
        }

        private void dormir () {
            if (horasDeldia > 23) {
                horasDeldia = horasDeldia + 8 - 24;
                horasRestantes = horasRestantes - 8;
            }
        }

}

