package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiudadNoEstrategia {

    private String nombre;
    private Integer visitas;
    private List<IEdificio> listaEdificios;
    private Coordenadas coordenadas;
    private String descripcion;
    private Ladron ladron;

    public CiudadNoEstrategia(String nombre, String descripcion, Coordenadas coordenadas, List<IEdificio> Edificios ){

        listaEdificios = new ArrayList<>();
        this.visitas = 0;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void setCoordenadas(String latitud, String longitud) {
        this.coordenadas = new Coordenadas(Double.parseDouble(latitud), Double.parseDouble(longitud));
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }


    public List<IEdificio> mostrarEdificios(){
        List <IEdificio> copiaListaEdificios = listaEdificios.stream().collect(Collectors.toList());
        return copiaListaEdificios;
    }

    public void calcularDistancia(CiudadNoEstrategia destino, Integer velocidad, Reloj reloj) {
       double distancia = coordenadas.calcularDistancia(destino.getUbicacion());
       int horas = (int) distancia / velocidad;
       if (horas == 0) horas +=1;
       reloj.descontarhoras(horas);
    }

    private Coordenadas getUbicacion() {
        return coordenadas;
    }

    public String visitarEdificio(IEdificio edificio, Reloj reloj, Visitante visitante) throws FileNotFoundException {

        if(visitas < 3){
            visitas += 1;
        }

        if(ladron != null){
            ladron.atacarConCuchillo(reloj);
        }

        reloj.descontarhoras(visitas);
        return null;
    }

    public IEdificio obtenerEdificio(int i) {
        return listaEdificios.get(i);
    }

    public void setLadron(Ladron ladronActual){
    }

    public boolean MostraSecuaz(String nombre){
        return this.nombre.equals(nombre);
    }

    public String getNombre(){
        return this.nombre;
    }


}
