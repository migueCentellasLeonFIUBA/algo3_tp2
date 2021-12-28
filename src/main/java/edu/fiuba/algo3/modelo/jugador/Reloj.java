package edu.fiuba.algo3.modelo.jugador;

import java.util.ArrayList;

public class Reloj {

    private Integer horasRestantes;
    private Integer horaDeldia;
    private Integer horasSueño;
    private Integer horasPorDia;
    private ArrayList<String> dias;
    private Integer diaActual;

    public Reloj() {
        this.horasRestantes = 168;
        this.horaDeldia = 8;
        this.horasSueño = 8;
        this.horasPorDia = 24;
        this.diaActual = 0;
        agregarDias();
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
            diaActual++;
        }
    }

    private void agregarDias(){
        dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miercoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sabado");
        dias.add("Domingo");
    }

    public String diaYHora(){
        String diaYYHora = dias.get(diaActual) + ", " + String.valueOf(horaDeldia) + "hs.";
        return diaYYHora;
    }

}