package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorJuegoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorJuego;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.Pistas.IPista;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Coordenadas;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.edificios.AeroPuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.*;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JuegoTest{

    @Test
    public void Test01PierdoElJuegoPorNoGenerarLaOrden() throws Exception {
        //----------------------------------------------------SetUp------------------------------------------------
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("rafael");
        juego.comenzarCaso();
//----------------------------------------------------Ciudad1 - Pekin----------------------------------------------
        ArrayList<Edificio> edificios = jugador.verEdificios();
        Edificio edificio1 = edificios.get(0);
        Edificio edificio2 = edificios.get(1);
        Edificio edificio3 = edificios.get(2);

        String pista1 = jugador.visitarEdificio(edificio1);
        String pista2 = jugador.visitarEdificio(edificio2);
        String pista3 = jugador.visitarEdificio(edificio3);

        assertTrue(pista1.contains("Mar Egeo"));
        assertTrue(pista2.contains("Euros"));
        assertTrue(pista3.contains("escudo espartano"));

        ArrayList<Ciudad> ciudades= jugador.verConexiones();

        Ciudad ciudad =  ciudades.get(1);//Seleccionar ciudad.

        jugador.viajarACiudad(ciudad);
//---------------------------------------------------Ciudad2 - Atenas -----------------------------------------------
        assertEquals("Atenas",ciudad.getNombre());
        edificios = jugador.verEdificios();

        edificio1 = edificios.get(0);
        edificio2 = edificios.get(1);
        edificio3 = edificios.get(2);

        pista1 = jugador.visitarEdificio(edificio1);
        pista2 = jugador.visitarEdificio(edificio2);
        pista3 = jugador.visitarEdificio(edificio3);

        assertTrue(pista1.contains("amarilla, verde y naranja"));
        assertTrue(pista2.contains("imperio britanico"));
        assertTrue(pista3.contains("rupias"));

        ciudades = jugador.verConexiones();

        ciudad =  ciudades.get(0);//Seleccionar ciudad.

        jugador.viajarACiudad(ciudad);

//----------------------------------------------------Ciudad3 - Colombo ------------------------------------------------
        assertEquals("Colombo",ciudad.getNombre());
        edificios = jugador.verEdificios();

        edificio1 = edificios.get(0);
        edificio2 = edificios.get(1);
        edificio3 = edificios.get(2);

        pista1 = jugador.visitarEdificio(edificio1);
        pista2 = jugador.visitarEdificio(edificio2);
        pista3 = jugador.visitarEdificio(edificio3);

        assertTrue(pista1.contains("Roja y blanca"));
        assertTrue(pista2.contains("Soles"));
        assertTrue(pista3.contains("Incas"));

        ciudades = jugador.verConexiones();

        ciudad =  ciudades.get(0);//Seleccionar ciudad.

        jugador.viajarACiudad(ciudad);

//----------------------------------------------------Ciudad4 - Lima ------------------------------------------------
        assertEquals("Lima",ciudad.getNombre());

        edificios = jugador.verEdificios();

        edificio1 = edificios.get(0);
        edificio2 = edificios.get(1);
        edificio3 = edificios.get(2);

        String accion1 = jugador.visitarEdificio(edificio1);
        String accion2 = jugador.visitarEdificio(edificio2);
        String accion3 = jugador.visitarEdificio(edificio3);
        ArrayList<String> conjuntoDeAcciones=new ArrayList<>();
        conjuntoDeAcciones.add(accion1);
        conjuntoDeAcciones.add(accion2);
        conjuntoDeAcciones.add(accion3);

        assert(conjuntoDeAcciones.contains("Ladron atrapado  pero usted no tiene la orden cargada, perdió el juego."));
        assert(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));
        assert(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));

    }

    @Test
    public void PerderJuego() throws Exception {

        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);
        Juego juego = director.obtenerJuego();
        Jugador jugador = juego.IdentificarJugador("Lucio");
        juego.comenzarCaso();

        ArrayList<Ciudad> destinos = new ArrayList<>();

        //viajo hasta quedarme sin horas
        for (int i = 0; i < 68; i++) {
            destinos = jugador.obtenerSiguientesDestinos();
            jugador.viajarACiudad(destinos.get(0));
        }

        assert(jugador.terminarJuego());
    }

    @Test
    public void elJugadorPierdeLasHorasViajando(){

        Juego juego = new Juego();

        //carga de objetos necesarios para un juego:
        ArrayList<String> listaCiudades = new ArrayList<>();

        String descripcion = "En el territorio de Ciudad De Mexico se encuentra tres bienes culturales de los " +
                "treinta y cinco sitios Patrimonio de la Humanidad con los que cuenta el país: el Centro Histórico, Xochimilco, " +
                "el Campus Central de la Ciudad Universitaria de la UNAM y la Casa y estudio de Luis Barragán. Cuenta con ciento cincuenta " +
                "y un museos que la pone como la segunda ciudad con más museos en el mundo, detrás de Londres. Además, fue la primera " +
                "ciudad de Latinoamérica en albergar unas olimpiadas al ser sede de los Juegos Olímpicos de 1968.";

        //"Ciudad de Mexico": ["Rio De Janeiro","Atenas", "Buenos Aires"],
        Coordenadas coordenadas1 = new Coordenadas(23.634501, -102.552784);
        Coordenadas coordenadas11 = new Coordenadas(-22.90642, -43.18223);
        Coordenadas coordenadas12 = new Coordenadas(37.98376, 23.72784);
        Coordenadas coordenadas13 = new Coordenadas(-34.6083, -58.3712);

        //"Pekin" :["Sydney", "Atenas","Bamako"],
        Coordenadas coordenadas2 = new Coordenadas(39.9035, 116.388);
        Coordenadas coordenadas21 = new Coordenadas(-33.8667, 151.2);
        Coordenadas coordenadas22 = new Coordenadas(37.98376, 23.72784);
        Coordenadas coordenadas23 = new Coordenadas(12.65, -8);

        //"Atenas" : ["Colombo", "Oslo", "Lima"],
        Coordenadas coordenadas3 = new Coordenadas(37.98376, 23.72784);
        Coordenadas coordenadas31 = new Coordenadas(6.93548, 79.84868);
        Coordenadas coordenadas32 = new Coordenadas(59.91273, 10.74609);
        Coordenadas coordenadas33 = new Coordenadas(-12.04318, -77.02824);

        //"Bamako": ["Moscu","Oslo","San Marino"],
        Coordenadas coordenadas4 = new Coordenadas(12.65, -8);
        Coordenadas coordenadas41 = new Coordenadas(55.75222, 37.61556);
        Coordenadas coordenadas42 = new Coordenadas(59.91273, 10.74609);
        Coordenadas coordenadas43 = new Coordenadas(43.94236, 12.457777);


        //primero creo las pistas necesarias:
        Map<String, String> pistasEdificio = new HashMap<>();
        pistasEdificio.put("facil", "Co-Piloto: le ví llevar una bandera con una roja y blanca, con una hoja de maple en el centro");
        pistasEdificio.put("media", "Co-Piloto: creo haberle visto practicar su francés,¡No era muy bueno!");
        pistasEdificio.put("dificil", "Co-Piloto: creo haberle escuchado decir que iba a visitar las cataratas Montgomery por primera vez");

        //creo el ladron:
        //"Merey Laroc":["Femenino","Tenis","Rojo","Tatuaje","Deportivo"],
        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Femenino");
        caracteristicas.add("Tenis");
        caracteristicas.add("Rojo");
        caracteristicas.add("Tatuaje");
        caracteristicas.add("Deportivo");

        Cualidades cualidades= new Cualidades(caracteristicas);
        Sospechoso sospechoso = new Sospechoso("Merey Laroc", cualidades);
        Ladron ladron = new Ladron(sospechoso);

        Pista pista = new Pista(pistasEdificio, ladron);

        ArrayList<Edificio> edificios = new ArrayList<>();

        //creo los edificios:
        AeroPuerto aeroPuerto = new AeroPuerto(pista);
        Biblioteca biblioteca = new Biblioteca(pista);
        Banco banco = new Banco(pista);

        edificios.add(biblioteca);
        edificios.add(aeroPuerto);
        edificios.add(banco);

        //public void agregarConexion(Mapa mapa, Ciudad ciudadAnterior);

        //"Ciudad de Mexico": ["Rio De Janeiro","Atenas", "Buenos Aires"],
        Ciudad ciudad1 = new Ciudad("Ciudad de Mexico", descripcion,  coordenadas1, edificios);
        Ciudad ciudad12 = new Ciudad("Atenas", descripcion,  coordenadas12, edificios);
        Ciudad ciudad13 = new Ciudad("Buenos Aires", descripcion,  coordenadas13, edificios);

        //"Pekin" :["Sydney", "Atenas","Bamako"],
        Ciudad ciudad2 = new Ciudad("Pekin", descripcion,  coordenadas2, edificios);
        Ciudad ciudad22 = new Ciudad("Rio De Janeiro", descripcion,  coordenadas22, edificios);
        Ciudad ciudad23 = new Ciudad("Bamako", descripcion,  coordenadas23, edificios);

        //"Atenas" : ["Colombo", "Oslo", "Lima"],
        Ciudad ciudad3 = new Ciudad("Bangkok", descripcion,  coordenadas3, edificios);
        Ciudad ciudad32 = new Ciudad("Oslo", descripcion,  coordenadas32, edificios);
        Ciudad ciudad33 = new Ciudad("Lima", descripcion,  coordenadas33, edificios);

        //"Bamako": ["Moscu","Oslo","San Marino"],
        Ciudad ciudad4 = new Ciudad("Budapest", descripcion,  coordenadas4, edificios);
        Ciudad ciudad41 = new Ciudad("Moscu", descripcion,  coordenadas41, edificios);
        Ciudad ciudad42 = new Ciudad("Paris", descripcion,  coordenadas42, edificios);
        Ciudad ciudad43 = new Ciudad("San Marino", descripcion,  coordenadas43, edificios);

        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(ciudad1);
        ciudades.add(ciudad12);
        ciudades.add(ciudad13);

        ciudades.add(ciudad2);
        ciudades.add(ciudad22);
        ciudades.add(ciudad23);

        ciudades.add(ciudad3);
        ciudades.add(ciudad32);
        ciudades.add(ciudad33);

        ciudades.add(ciudad4);
        ciudades.add(ciudad41);
        ciudades.add(ciudad42);
        ciudades.add(ciudad43);

        listaCiudades.add(ciudad1.getNombre());
        listaCiudades.add(ciudad2.getNombre());
        listaCiudades.add(ciudad3.getNombre());
        listaCiudades.add(ciudad4.getNombre());

        //cargo el diccionario de las ciudades:
        Map<String, Ciudad> ciudadesjuego = new HashMap<>();
        ciudadesjuego.put("Ciudad de Mexico", ciudad1);
        ciudadesjuego.put("Atenas", ciudad12);
        ciudadesjuego.put("Buenos Aires", ciudad13);

        ciudadesjuego.put("Pekin", ciudad2);
        ciudadesjuego.put("Rio De Janeiro", ciudad22);
        ciudadesjuego.put("Bamako", ciudad23);

        ciudadesjuego.put("Bangkok", ciudad3);
        ciudadesjuego.put("Oslo", ciudad32);
        ciudadesjuego.put("Lima", ciudad33);

        ciudadesjuego.put("Budapest", ciudad4);
        ciudadesjuego.put("Moscu", ciudad41);
        ciudadesjuego.put("Paris", ciudad42);
        ciudadesjuego.put("San Marino", ciudad43);

        //**************
        juego.setCiudades(ciudadesjuego);

        //cargo el mapa
        Map<Ciudad, ArrayList<Ciudad>> conexiones = new HashMap<>();
        ArrayList<Ciudad> conectadas1 = new ArrayList<>();
        conectadas1.add(ciudad2);
        conectadas1.add(ciudad12);
        conectadas1.add(ciudad13);

        conexiones.put(ciudad1, conectadas1);

        ArrayList<Ciudad> conectadas2 = new ArrayList<>();
        conectadas2.add(ciudad2);
        conectadas2.add(ciudad3);
        conectadas2.add(ciudad23);

        conexiones.put(ciudad2, conectadas2);

        ArrayList<Ciudad> conectadas3 = new ArrayList<>();
        conectadas3.add(ciudad3);
        conectadas3.add(ciudad4);
        conectadas3.add(ciudad33);

        conexiones.put(ciudad3, conectadas3);

        ArrayList<Ciudad> conectadas4 = new ArrayList<>();
        conectadas4.add(ciudad3);
        conectadas4.add(ciudad42);
        conectadas4.add(ciudad43);

        conexiones.put(ciudad4, conectadas4);

        Mapa mapa = new Mapa(conexiones);

        //**************
        juego.setMapa(mapa);

        //creo la estrategia:
        Estrategia estrategia = new Estrategia(listaCiudades); //seteo la ruta.
        //public void aplicarEstrategia(Map<String, Ciudad> ciudades, Map<String, Map<String, IPista>> pistas, Ladron ladron,Mapa mapa)

        Map<String, ISospechable> sospechosos = new HashMap<>();

        //public Sospechoso(String nombre,Cualidades cualidades){

        sospechosos.put("Merey Laroc", sospechoso);

        //**************
        juego.setSospechosos(sospechosos);


        //public Pista(Map<String, String> pistasMap, ILadron ladron)

        Map<String, IPista> pistasCiudad = new HashMap<>();

        //cargo las mismas pistas para todas las ciudades:
        ArrayList<String> nombreEdificios = new ArrayList<>();
        nombreEdificios.add("Biblioteca");
        nombreEdificios.add("Aeropuerto");
        nombreEdificios.add("Banco");

        for(String edificio : nombreEdificios){
            pistasCiudad.put(edificio, pista); //cargo la misma pista para todos los edificios.
        }

        Map<String, Map<String,IPista> > pistasCiudades= new HashMap<>();

        for(Ciudad ciudad : ciudades){
            pistasCiudades.put(ciudad.getNombre(), pistasCiudad); //cargo la misma pista para todos los edificios.
        }

        estrategia.aplicarEstrategia(ciudadesjuego, pistasCiudades, ladron, mapa);
        Objeto objeto = new Objeto("Huevo de 1000 años", estrategia);

        Map<String, ArrayList<Objeto>> objetos = new HashMap<>();
        ArrayList<Objeto> tiposObjetos = new ArrayList<>();
        tiposObjetos.add(objeto);
        objetos.put("Comun", tiposObjetos);

        //**************
        juego.setObjetos(objetos);


        //**************
        juego.setPistas(pistasCiudades);

        Map<String, Jugador> jugadores = new HashMap<>();

        //**************
        juego.setJugadores(jugadores);

        Jugador jugador = juego.IdentificarJugador("Lucio");
        try {
            juego.comenzarCaso();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Ciudad> destinos = new ArrayList<>();

        //ya estan cargados todos los objetos necesarios para la prueba de perder el juego.

        //viajo hasta quedarme sin horas
        int i;
        int tope = 37;
        for (i = 0; i < tope; i++) {
            destinos = jugador.obtenerSiguientesDestinos();

            if(i%2==0)
                jugador.viajarACiudad(destinos.get(0));
            else
                jugador.viajarACiudad(destinos.get(1));
        }

        assert(jugador.terminarJuego());
    }

}
