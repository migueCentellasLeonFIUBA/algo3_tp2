package edu.fiuba.algo3.modelo.ciudades;

import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;
import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.LadronNulo;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;

import java.util.ArrayList;
import java.util.Map;

public class Ciudad {
    protected final Coordenadas coordenadas;
    private final String nombreCiudad;
    private final String descripcion;
    private final ArrayList<IEdificio> edificios;
    private Integer visitas;
    private IEstado estado;


    public Ciudad(String nombreCiudad,String descripcion,Coordenadas coordenadas,ArrayList<IEdificio> edificios) {
        this.nombreCiudad = nombreCiudad;
        this.descripcion = descripcion;
        this.coordenadas = coordenadas;
        this.edificios = edificios;
        this.visitas = 0;
        this.estado = new SinEstrategia();
    }

    public ArrayList<IEdificio> MostrarEdificios() {
        return this.edificios;
    }

    public Integer calcularHoras(Ciudad destino, GradoPolicia grado) {
        double distancia = coordenadas.calcularDistancia(destino.getUbicacion());
        return grado.calcularHoras( distancia);
    }

    public void viajarACiudad(Ciudad destino, Reloj reloj, GradoPolicia grado){
        reloj.descontarhoras(calcularHoras(destino, grado));
    }

    public String visitarEdificio(IEdificio edificio, Reloj reloj){

        if(visitas < 3){
            visitas++;
        }
        reloj.descontarhoras(visitas);
        return null;
    }

    public String nombre(){
        return nombreCiudad;
    }

    private Coordenadas getUbicacion() {
        return coordenadas;
    }

    public void cambiarPistas(Map<String, IPista> pistasEdificios, Ladron ladron) {
        Randomizador random = new Randomizador();
        Integer posEdificioRandom = random.obtenerIntegerRandom(pistasEdificios.size());
        Integer indice=0;
        for(IEdificio edificio: edificios){
           if(indice==posEdificioRandom){
               edificio.cambiarPista(pistasEdificios, ladron);
           }else{
               edificio.cambiarPista(pistasEdificios,new LadronNulo());
           }
           indice+=1;
        }
    }
}
