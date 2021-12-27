package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiudadNoEstrategia extends Ciudad{
    public CiudadNoEstrategia(String nombreCiudad,String descripcion,Coordenadas coordenadas,ArrayList<IEdificio> edificios) {
        super(nombreCiudad,descripcion,coordenadas,edificios);
    }

    /*public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }*/

    /*public void calcularDistancia(CiudadNoEstrategia destino, Integer velocidad, Reloj reloj) {
       double distancia = coordenadas.calcularDistancia(destino.getUbicacion());
       int horas = (int) distancia / velocidad;
       if (horas == 0) horas +=1;
       reloj.descontarhoras(horas);
    }*/

    /*private Coordenadas getUbicacion() {
        return coordenadas;
    }*/

    /*public void setLadron(Ladron ladronActual){
    }*/




}
