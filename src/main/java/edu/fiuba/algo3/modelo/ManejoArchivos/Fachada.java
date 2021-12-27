package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.SinPista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.ciudades.Coordenadas;
import edu.fiuba.algo3.modelo.edificios.ComandoCreadorEdficios;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.NoOrden;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;
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
                ArrayList<String> caracteristicas = parser.pedirArreglo(nombre);
                Cualidades cualidades = new Cualidades(caracteristicas);
                Sospechoso sospechoso = new Sospechoso(nombre, cualidades);
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
            Double latitud = Double.valueOf(parser.pedirValor("latitud"));
            Double longitud =Double.valueOf(parser.pedirValor("longitud"));
            Coordenadas coordenadas = new Coordenadas(latitud,longitud );
            String descripcion = parser.pedirValor("descripcion");
            ArrayList<IEdificio> edificios = cargarEdificios();
            CiudadNoEstrategia ciudad = new CiudadNoEstrategia(nombreCiudad,descripcion ,coordenadas,edificios);
            resultado.put(nombreCiudad,ciudad);
        }

        return resultado;
    }

    private ArrayList<IEdificio> cargarEdificios(){
        List<String> edificios = parser.pedirArregloFiltrado("Edificios");
        ArrayList<IEdificio> resultado = new ArrayList<>();
        for (String nombreEdificio: edificios){
            ComandoCreadorEdficios comando = new ComandoCreadorEdficios();
            IEdificio edificio = comando.crearEdificio(nombreEdificio, new SinPista());
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
            Estrategia estrategia = new Estrategia(parser.pedirArregloFiltrado("Estrategia"));
            Objeto objeto = new Objeto(nombreObjeto,estrategia);
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
                Jugador jugador = new Jugador(nombreJugador,Integer.parseInt(parser.pedirValor("Arrestos")), new Reloj());
                resultado.put(nombreJugador,jugador);
            }
               return resultado;
        }

        public Map<String,Map<String, IPista>> cargarPistas(){
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json");
        ArrayList<String> ciudades=parser.listaDeElementos();
        Map<String,Map<String, IPista>> pistasCiudades = new HashMap<>();
        Map<String, IPista> pistasEdificios;

        for (String ciudad:ciudades){
            parser.filtrar(ciudad);
            pistasEdificios = new HashMap<>();
            for(String edificio : parser.listaDeElementosFiltrados()){
                parser.filtrarDeNuevo(edificio);
                Map<String, String> pistasMap = new HashMap<>();
                for (String dificultad:  parser.listaDeElementosFiltrados()){
                    pistasMap.put(dificultad,parser.pedirValor(dificultad));
                }
                Pista pista = new Pista(pistasMap, new LadronNulo());
                pistasEdificios.put(edificio,pista);
                parser.filtrar(ciudad);
            }
            pistasCiudades.put(ciudad,pistasEdificios);
        }
        return pistasCiudades;
        }

    public Map<Ciudad, ArrayList<Ciudad>> cargarConexiones(Map<String, Ciudad> ciudades) throws Exception {
        if(ciudades == null) throw new Exception("Ciudades está nulo, imposible ver conexiones.");
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Conexiones.json");
        ArrayList<String> conexiones = parser.listaDeElementos();
        Map<Ciudad, ArrayList<Ciudad>> resultado = new HashMap<>();
        ArrayList<Ciudad> ciudadesMapa = new ArrayList<>();

        //por cada nombre key en el archivo conexion:
        for (String nombreCiudad : conexiones) {
            //parser.filtrar(nombreCiudad);
            //por cada ciudad en el arreglo de conexiones:
            for (String ciudad : parser.pedirArregloFiltrado(nombreCiudad)) {
                ciudadesMapa.add(ciudades.get(ciudad)); //devuelve la instancia de la ciudad.
            }
            resultado.put(ciudades.get(nombreCiudad), ciudadesMapa);
        }

        return resultado;
    }



}
