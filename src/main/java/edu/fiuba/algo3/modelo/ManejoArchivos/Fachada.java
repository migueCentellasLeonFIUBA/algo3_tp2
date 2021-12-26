package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.Pistas.IPistas;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadEstrategia;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.ciudades.Coordenadas;
import edu.fiuba.algo3.modelo.edificios.ComandoCreadorEdficios;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.NoOrden;
import edu.fiuba.algo3.modelo.ladron.Cualidades;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import edu.fiuba.algo3.modelo.objetos.Objeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fachada{

    IParser parser;

    public Fachada(IParser nuevoParser){
        parser=nuevoParser;
    }

    public Map<String, ISospechable> cargarSospechosos(){
            parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json");
            ArrayList<String> sospechososNombres = parser.listaDeElementos();
            Map<String, ISospechable> resultado = new HashMap<>();
            for (String nombre : sospechososNombres){
                Sospechoso sospechoso = new Sospechoso(nombre, new Cualidades());
                resultado.put(nombre, sospechoso);
            }

        return resultado;
    }

    public Map<String, Ciudad> cargarCiudades(){
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json");
        ArrayList<String> ciudades=parser.listaDeElementos();
        Map<String, Ciudad> resultado = new HashMap<>();

        for (String nombreCiudad :ciudades){
            parser.filtrar(nombreCiudad);
            //Build Cordenadas.
            Double latitud = Double.valueOf(parser.pedirValor("latitud"));
            Double longitud =Double.valueOf(parser.pedirValor("longitud"));
            Coordenadas coordenadas = new Coordenadas(latitud,longitud );
            //Bulid Descripcion
            String descripcion = parser.pedirValor("descripcion");
            //Build Edificios
            ArrayList<IEdificio> edificios = cargarEdificios();
            //getCiudad
            CiudadNoEstrategia ciudad = new CiudadNoEstrategia(nombreCiudad,descripcion ,coordenadas,edificios);
            resultado.put(nombreCiudad,ciudad);
        }

        return resultado;
    }

    private ArrayList<IEdificio> cargarEdificios(){
        List<String> edificios = parser.pedirArreglo("Edificios");
        ArrayList<IEdificio> resultado = new ArrayList<>();
        for (String nombreEdificio: edificios){
            ComandoCreadorEdficios comando = new ComandoCreadorEdficios();
            IEdificio edificio = comando.crearEdificio(nombreEdificio);
            resultado.add(edificio);
        }
        return resultado;
    }

    public Map<String, ArrayList<Objeto>> cargarObjetos(){
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json");
        ArrayList<String> nombreObjetos = parser.listaDeElementos();
        Map<String,ArrayList<Objeto>> resultado = new HashMap<>();

        for (String nombreObjeto: nombreObjetos){
            parser.filtrar(nombreObjeto);
            String tipo = parser.pedirValor("Rareza");
            Objeto objeto = new Objeto(nombreObjeto);//cargar con ciudad tambien
            ArrayList<Objeto> aux = resultado.getOrDefault(tipo,new ArrayList<>());
            aux.add(objeto);
            resultado.put(parser.pedirValor("Rareza"),aux);
        }
        return resultado;
    }

        public Map<String, Jugador> cargarJugadores() {
            parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Jugadores.json");
            ArrayList<String> jugadores = parser.listaDeElementos();
            Map<String,Jugador> resultado = new HashMap<>();

            for (String nombreJugador: jugadores){
                parser.filtrar(nombreJugador);
                Jugador jugador = new Jugador(nombreJugador,Integer.parseInt(parser.pedirValor("Arrestos")), new NoOrden());
                resultado.put(nombreJugador,jugador);
            }

            return resultado;
        }

        public Map<String, IPistas> cargarPistas(){
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json");
        ArrayList<String> pistas=parser.listaDeElementos();

        for (String nombrePistas:pistas){
        }
        return null;
        }


}
