package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.edificios.IEdificio;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Ciudad {

    Integer visitas;
    private final Coordenadas coordenadas;
    private final String nombreCiudad;
    private final String descripcion;
    private final ArrayList<IEdificio> edificios;


    public Ciudad(String nombreCiudad,String descripcion,Coordenadas coordenadas,ArrayList<IEdificio> edificios) {
        this.nombreCiudad = nombreCiudad;
        this.descripcion = descripcion;
        this.coordenadas = coordenadas;
        this.edificios = edificios;
        this.visitas = 0;

    }

    public ArrayList<IEdificio> MostrarEdificios() {
        return this.edificios;
    }


    public Integer calcularDistancia(Ciudad destino, Integer velocidad) {
        double distancia = coordenadas.calcularDistancia(destino.getUbicacion());
        int horas = (int) distancia / velocidad;
        if (horas == 0) horas +=1;
        return horas;
    }

    protected Coordenadas getUbicacion() {
        return coordenadas;
    }

    public void viajarACiudad(Ciudad destino, Reloj reloj, GradoPolicia grado){
        reloj.descontarhoras(calcularDistancia(destino, grado.velocidad()));

    }


    public String visitarEdificio(IEdificio edificio, Reloj reloj, Visitante visitante) throws FileNotFoundException {

        if(visitas < 3){
            visitas++;
        }
        reloj.descontarhoras(visitas);
        return null;
    }

    public String nombre(){
        return nombreCiudad;
    }

}
