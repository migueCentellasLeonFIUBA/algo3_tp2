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
;
    private Ladron ladron;

    private String proximaCiudad;

    public Ciudad(String ciudad){
        this.visitas = 0;
        this.nombre = nombre;
        listaEdificios = new ArrayList<>();
    }




    public String getNombre() {
        return this.nombre;
    }



    public void setCordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Edificio> mostrarEdificios(){
        List <Edificio> copiaListaEdificios = listaEdificios.stream().collect(Collectors.toList());
        return copiaListaEdificios;
    }



    public int calcularDistancia(Ciudad destino) {
        return coordenadas.calcularDistancia(destino.getUbicacion());
    }

    //opcion2:
    public void calcularDistancia(Ciudad destino, Integer velocidad, Reloj reloj) {
        coordenadas.calcularDistancia(destino.getUbicacion(), velocidad,reloj);
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
}
