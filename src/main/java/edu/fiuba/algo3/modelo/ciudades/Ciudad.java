package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad{

    private String nombre;
    private Integer visitas;
    private List<Edificio> listaEdificios;
    private Coordenadas coordenadas;
    private String descripcion;

    private Ladron ladron;

    private String proximaCiudad;

    public Ciudad(){
        listaEdificios = new ArrayList<>();
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


    public List<Edificio> mostrarEdificios(){
        List <Edificio> copiaListaEdificios = listaEdificios.stream().collect(Collectors.toList());
        return copiaListaEdificios;
    }

    public void calcularDistancia(Ciudad destino, Integer velocidad, Reloj reloj) {
       double distancia = coordenadas.calcularDistancia(destino.getUbicacion());
       int horas = (int) distancia / velocidad;
       if (horas == 0) horas +=1;
       reloj.descontarhoras(horas);
    }

    private Coordenadas getUbicacion() {
        return coordenadas;
    }

    public String visitarEdificio(Edificio edificio, Reloj reloj, GradoPolicia grado) throws FileNotFoundException {

        if(visitas < 3){
            visitas += 1;
        }

        if(ladron != null){
            ladron.atacarConCuchillo(reloj);
        }

        reloj.descontarhoras(visitas);


        return edificio.visitarEdificio(proximaCiudad, grado);
    }

    public Edificio obtenerEdificio(int i) {
        return listaEdificios.get(i);
    }

    public void setLadron(Ladron ladronActual){
    }

    public boolean compararCiudad(Ciudad ciudad){
        return this.nombre == ciudad.getNombre();
    }

    public String getNombre(){
        return this.nombre;
    }


}
