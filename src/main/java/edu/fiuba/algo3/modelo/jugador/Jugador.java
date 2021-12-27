package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Computadora computadora;
    private Reloj reloj;
    private GradoPolicia grado;
    private Caso caso;
    private Ciudad ciudadActual;


    public Jugador(String nombre,Integer arrestos,Reloj reloj){
        this.nombre=nombre;
        this.grado = new Novato();
        asignarGrado(arrestos);
        this.reloj = reloj;
        this.ciudadActual = ciudadActual;
    }

    public void setCiudadActual(Ciudad actual){
        this.ciudadActual = actual;
    }


    private void asignarGrado(int arrestos){
        for(int i = arrestos; i != 0; i--){
            this.grado = this.grado.arresto();
        }
    }

    public void terminarJuego() {
        //refactor: no debería tener atributos sin inicializar Memento al juego
    }

    public String visitarEdificio(IEdificio edificio) throws FileNotFoundException {
        //String pista = ciudadActual.visitarEdificio(edificio, reloj, visitante);
        if(reloj.tiempoTerminado()){
            terminarJuego();
        }

        return "";
    }

    public Objeto ObjetoRobado(Map<String, ArrayList<Objeto>> objetos) {
        Objeto objeto = grado.ObtenerObjeto(objetos);
        return objeto;
    }

    public void empezarCaso(Caso caso,Computadora computadora) {
        this.caso = caso;
        this.computadora = computadora;
    }
}
