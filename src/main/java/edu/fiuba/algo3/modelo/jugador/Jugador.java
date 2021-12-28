package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import edu.fiuba.algo3.modelo.rangos.Novato;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class Jugador {

    private String nombre;
    private Reloj reloj;
    private GradoPolicia grado;
    private Caso caso;
    private Mapa mapa;


    public Jugador(String nombre,Integer arrestos,Reloj reloj,Mapa mapa){
        this.nombre=nombre;
        this.grado = new Novato();
        asignarGrado(arrestos);
        this.reloj = reloj;
        this.mapa=mapa;
    }

    public void viajarACiudad(Ciudad destino){
        mapa.viajarACiudad(destino, reloj, grado);
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


    public void empezarCaso(Caso caso) {
        this.caso= caso;
    }
}
