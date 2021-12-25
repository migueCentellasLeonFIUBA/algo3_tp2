package edu.fiuba.algo3.modelo.ManejoArchivos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadEstrategia;
import edu.fiuba.algo3.modelo.ciudades.CiudadNoEstrategia;
import edu.fiuba.algo3.modelo.ciudades.Coordenadas;
import edu.fiuba.algo3.modelo.edificios.ComandoCreadorEdficios;
import edu.fiuba.algo3.modelo.edificios.IEdificio;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import edu.fiuba.algo3.modelo.objetos.Comun;
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

    public Sospechosos cargarSospechosos(){
            parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json");
            //ArrayList<Sospechoso> sospechosos = new ArrayList<Sospechoso();
            ArrayList<String> sospechososNombres = parser.listaDeElementos();

            for (String nombre:sospechososNombres){


            }

        return null;
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
            ArrayList<IEdificio> edificios = cargarEdificios(nombreCiudad);
            //getCiudad
            CiudadEstrategia ciudad = new CiudadEstrategia(nombreCiudad,descripcion ,coordenadas,edificios);
            resultado.put(nombreCiudad,ciudad);
        }

        return resultado;
    }

    private ArrayList<IEdificio> cargarEdificios(String nombreCiudad){
        List<String> edificios = parser.pedirArreglo("Edificios");
        ArrayList<IEdificio> resultado = new ArrayList<IEdificio>();

        //ObtenerPista para crear la ciudad con la pista que le corresponde.
        for (String nombreEdificio: edificios){
            ComandoCreadorEdficios comando = new ComandoCreadorEdficios();
            IEdificio edificio = comando.crearEdificio(nombreEdificio);
            resultado.add(edificio);
        }
        return resultado;
    }


    public Map<String,Objeto> cargarObjetos(){
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Objetos.json");
        ArrayList<String> objetos = parser.listaDeElementos();
        Map<String,Objeto> resultado = new HashMap<>();

        for (String nombreObjeto: objetos){
            parser.filtrar(nombreObjeto);
            Objeto objeto = new Objeto(nombreObjeto);
            resultado.put(parser.pedirValor("Rareza"),objeto);
        }
        return resultado;
    }

    public Sospechosos cargarPistas(CiudadNoEstrategia ciudad){
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json");

        ArrayList<String> pistas=parser.listaDeElementos();

        for (String p:pistas){

        }
        return null;
    }
}
