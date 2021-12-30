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
//----------------------------------------------------Ciudad2 - Atenas -----------------------------------------------
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

        assertTrue(conjuntoDeAcciones.contains("Ladron atrapado  pero usted no tiene la orden cargada, perdió el juego."));
        assertTrue(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));
        assertTrue(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));

    }


    @Test
    public void Test02JugadorPierdePorArrestarLadronConOrdenIncorrecta() throws Exception {

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

        /*
        ---------Sospechoso-------------
         "Merey Laroc":{
            "Sexo": "Femenino",
            "Hobby" : "Tenis",
            "Cabello" : "Rojo",
            "Senia" : "Tatuaje",
            "Vehiculo" : "Deportivo"
          },
         */

        //Seteo de caracterisiticas
        jugador.siguienteSexo();
        jugador.siguienteHobby();
        jugador.siguienteHobby();
        jugador.siguienteHobby();
        jugador.siguienteHobby();
        jugador.siguienteHobby();
        jugador.siguienteHobby();
        jugador.siguienteCabello();
        jugador.siguienteCabello();
        jugador.siguienteSenia();
        jugador.siguienteSenia();
        jugador.siguienteSenia();
        jugador.siguienteVehiculo();
        jugador.siguienteVehiculo();
        jugador.siguienteVehiculo();

        //Hay un solo seospechoso que cumple estas caracteristicas, pero no es el ladron
        jugador.buscarSospechosos();

        String accion1 = jugador.visitarEdificio(edificio1);
        String accion2 = jugador.visitarEdificio(edificio2);
        String accion3 = jugador.visitarEdificio(edificio3);
        ArrayList<String> conjuntoDeAcciones=new ArrayList<>();
        conjuntoDeAcciones.add(accion1);
        conjuntoDeAcciones.add(accion2);
        conjuntoDeAcciones.add(accion3);

        assertTrue(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));
        assertTrue(conjuntoDeAcciones.contains("Ladron atrapado , orden emitida para el Sospechoso equivocado, perdió el juego."));
    }

    @Test
    public void Test03JugadorGanaPorArrestarLadronConOrdenCorrecta() throws Exception {

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

        /*
        ---------Ladron-------------
         "Carmen San Diego":{
            "Sexo": "Femenino",
            "Hobby" : "Croquet",
            "Cabello" : "Negro",
            "Senia" : "Joyas",
            "Vehiculo" : "Limusina"
          },
         */

        //Seteo de caracterisiticas
        jugador.siguienteSexo();
        jugador.siguienteHobby();
        jugador.siguienteHobby();
        jugador.siguienteCabello();
        jugador.siguienteCabello();
        jugador.siguienteCabello();
        jugador.siguienteSenia();
        jugador.siguienteVehiculo();
        jugador.siguienteVehiculo();


        //Hay un solo seospechoso que cumple estas caracteristicas, pero no es el ladron
        jugador.buscarSospechosos();

        String accion1 = jugador.visitarEdificio(edificio1);
        String accion2 = jugador.visitarEdificio(edificio2);
        String accion3 = jugador.visitarEdificio(edificio3);
        ArrayList<String> conjuntoDeAcciones=new ArrayList<>();
        conjuntoDeAcciones.add(accion1);
        conjuntoDeAcciones.add(accion2);
        conjuntoDeAcciones.add(accion3);

        assertTrue(conjuntoDeAcciones.contains("Estan ocurriendo cosas muy turbias en esta ciudad! Fuiste apuñalado, el ladron justo se escapo del edificio."));

        int coincidencias = 0;
        for (String accion : conjuntoDeAcciones){
            if (accion.contains("Ladron atrapado"))
                coincidencias +=1;
        }

        assertEquals(1, coincidencias);
    }

    @Test
    public void elJugadorPierdeLasHorasViajandoYPierdeElJuego() {

        Juego juego = new Juego();

        //carga de objetos necesarios para un juego:
        ArrayList<String> listaCiudades = new ArrayList<>();

        //cada ciudad tiene una descripcion.
        String descripcion = "En el territorio de Ciudad De Mexico se encuentra tres bienes culturales de los " +
                "treinta y cinco sitios Patrimonio de la Humanidad con los que cuenta el país: el Centro Histórico, Xochimilco, " +
                "el Campus Central de la Ciudad Universitaria de la UNAM y la Casa y estudio de Luis Barragán. Cuenta con ciento cincuenta " +
                "y un museos que la pone como la segunda ciudad con más museos en el mundo, detrás de Londres. Además, fue la primera " +
                "ciudad de Latinoamérica en albergar unas olimpiadas al ser sede de los Juegos Olímpicos de 1968.";

        //cada ciudad tiene una coordenada
        //las coordenadas se encargan de calcular la distancia entre ciudades
        Coordenadas coordenadas1 = new Coordenadas(23.634501, -102.552784);
        Coordenadas coordenadas12 = new Coordenadas(37.98376, 23.72784);

        Coordenadas coordenadas2 = new Coordenadas(39.9035, 116.388);
        Coordenadas coordenadas22 = new Coordenadas(37.98376, 23.72784);

        Coordenadas coordenadas3 = new Coordenadas(37.98376, 23.72784);
        Coordenadas coordenadas32 = new Coordenadas(59.91273, 10.74609);

        Coordenadas coordenadas4 = new Coordenadas(12.65, -8);
        Coordenadas coordenadas41 = new Coordenadas(55.75222, 37.61556);


//*************************************PISTAS****************************************************

        //primero creo las pistas necesarias:
        //el nucleo de una pista es, su dificultad y el contenido.
        //la clase Pista contiene este diccionario.
        Map<String, String> pistasEdificio = new HashMap<>();
        pistasEdificio.put("facil", "Co-Piloto: le ví llevar una bandera con una roja y blanca, con una hoja de maple en el centro");
        pistasEdificio.put("media", "Co-Piloto: creo haberle visto practicar su francés,¡No era muy bueno!");
        pistasEdificio.put("dificil", "Co-Piloto: creo haberle escuchado decir que iba a visitar las cataratas Montgomery por primera vez");


        //***************************LADRON Y SOSPECHOSOS**************************

        //los sospechosos son los del caso, tienen las caracteristicas, cabello, hobby, etc, ubicadas en Cualidades.
        ArrayList<String> caracteristicas = new ArrayList<>();
        caracteristicas.add("Femenino"); //sexo
        caracteristicas.add("Tenis"); //hobby
        caracteristicas.add("Rojo");  //cabello
        caracteristicas.add("Tatuaje"); //senia
        caracteristicas.add("Deportivo"); //vehiculo

        //creo los sospechosos
        //***para este caso, creo solo uno.***
        Cualidades cualidades = new Cualidades(caracteristicas);
        Sospechoso sospechoso = new Sospechoso("Merey Laroc", cualidades);

        //un ladron se crea con un sospechoso.
        Ladron ladron = new Ladron(sospechoso);

        //la pista necesita al ladron, para dar cuando corresponda una pista sobre el ladron.
        Pista pista = new Pista(pistasEdificio, ladron);

        //***********************EDIFICIOS************************
        ArrayList<Edificio> edificios = new ArrayList<>();

        //creo los edificios, para colocar en las ciudades:
        AeroPuerto aeroPuerto = new AeroPuerto(pista);
        Biblioteca biblioteca = new Biblioteca(pista);
        Banco banco = new Banco(pista);

        edificios.add(biblioteca);
        edificios.add(aeroPuerto);
        edificios.add(banco);

//************************************CIUDAD**************************************

        Ciudad ciudad1 = new Ciudad("Ciudad de Mexico", descripcion, coordenadas1, edificios);
        Ciudad ciudad12 = new Ciudad("Atenas", descripcion, coordenadas12, edificios);

        Ciudad ciudad2 = new Ciudad("Pekin", descripcion, coordenadas2, edificios);
        Ciudad ciudad22 = new Ciudad("Rio De Janeiro", descripcion, coordenadas22, edificios);

        Ciudad ciudad3 = new Ciudad("Bangkok", descripcion, coordenadas3, edificios);
        Ciudad ciudad32 = new Ciudad("Oslo", descripcion, coordenadas32, edificios);

        Ciudad ciudad4 = new Ciudad("Budapest", descripcion, coordenadas4, edificios);
        Ciudad ciudad41 = new Ciudad("Moscu", descripcion, coordenadas41, edificios);

        //cargo todas las cuidades en una lista auxiliar.
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(ciudad1);
        ciudades.add(ciudad12);

        ciudades.add(ciudad2);
        ciudades.add(ciudad22);

        ciudades.add(ciudad3);
        ciudades.add(ciudad32);

        ciudades.add(ciudad4);
        ciudades.add(ciudad41);

        //cargo un diccionario que contiene el juego con todas las instancias de ciudades creadas
        //este diccionario sirve para obtener una instancia de ciudad, ne base al nombre
        //esto permite que las ciudades SE CREEN UNA SOLA VEZ.
        Map<String, Ciudad> ciudadesjuego = new HashMap<>();
        ciudadesjuego.put("Ciudad de Mexico", ciudad1);
        ciudadesjuego.put("Atenas", ciudad12);

        ciudadesjuego.put("Pekin", ciudad2);
        ciudadesjuego.put("Rio De Janeiro", ciudad22);

        ciudadesjuego.put("Bangkok", ciudad3);
        ciudadesjuego.put("Oslo", ciudad32);

        ciudadesjuego.put("Budapest", ciudad4);
        ciudadesjuego.put("Moscu", ciudad41);


        //**************
        juego.setCiudades(ciudadesjuego);

//*************************************MAPA*********************************************

        //cargo el diccionario de las ciudades, que contiene el mapa:
        //este diccionario, guarda el par, ciudad, ciudades conexion.
        //ciudades conexion: son las ciudades que se muestran en el mapa como opcion posible para viajar
        //las ciudades estan conectadas como un grafo.
        Map<Ciudad, ArrayList<Ciudad>> conexiones = new HashMap<>();
        ArrayList<Ciudad> conectadas1 = new ArrayList<>();
        conectadas1.add(ciudad2);
        conectadas1.add(ciudad12);

        conexiones.put(ciudad1, conectadas1);

        ArrayList<Ciudad> conectadas2 = new ArrayList<>();
        conectadas2.add(ciudad2);
        conectadas2.add(ciudad3);

        conexiones.put(ciudad2, conectadas2);

        ArrayList<Ciudad> conectadas3 = new ArrayList<>();
        conectadas3.add(ciudad3);
        conectadas3.add(ciudad4);

        conexiones.put(ciudad3, conectadas3);

        ArrayList<Ciudad> conectadas4 = new ArrayList<>();
        conectadas4.add(ciudad3);

        conexiones.put(ciudad4, conectadas4);

        //creo el mapa con el diccionario recien creado
        Mapa mapa = new Mapa(conexiones);

        //**************
        juego.setMapa(mapa);

//**********************************SOSPECHOSOS*************************************

        //el juego usa un diccionario en el que se encuentra el par:
        //nombre, instancia del sospechoso
        //se usa la misma estrategia para las ciudades, LOS SOSPECHOSOS SE CREAN UNA SOLA VEZ
        //gracias al diccionario, manteninendo las mismas instancias, para todos los casos.
        Map<String, ISospechable> sospechosos = new HashMap<>();
        sospechosos.put("Merey Laroc", sospechoso);

        //cargo el diccionario de sospechosos en el juego:
        juego.setSospechosos(sospechosos);

//*********************************PISTAS JUEGO**************************************

        Map<String, IPista> pistasCiudad = new HashMap<>();

        //cargo las mismas pistas para todas las ciudades:
        ArrayList<String> nombreEdificios = new ArrayList<>();
        nombreEdificios.add("Biblioteca");
        nombreEdificios.add("Aeropuerto");
        nombreEdificios.add("Banco");

        //Cada ciudad tiene asignado un diccionario de pistas, en donde:
        //cada edificio tiene asignada una clase pista (antes mostrada) y una ciudad tiene 3 edificios.
        for (String edificio : nombreEdificios) {
            pistasCiudad.put(edificio, pista); //cargo la misma pista para todos los edificios.
        }

        Map<String, Map<String, IPista>> pistasCiudades = new HashMap<>();

        //el juego tiene un diccionario de diccionarios, en donde aparece el par:
        //<nombre ciudad, diccionario de pistas>, el diccionario de pistas es el recien creado.
        //esto permite que LAS PISTAS SE CREEN UNA SOLA VEZ.
        for (Ciudad ciudad : ciudades) {
            pistasCiudades.put(ciudad.getNombre(), pistasCiudad); //cargo la misma pista para todos los edificios.
        }

        //**************
        juego.setPistas(pistasCiudades);

//**************************ESTRATEGIA Y OBJETOS*******************************

        //defino la ruta del ladron
        listaCiudades.add(ciudad1.getNombre()); //ciudad de mexico
        listaCiudades.add(ciudad2.getNombre()); //pekin
        listaCiudades.add(ciudad3.getNombre()); //bangkok
        listaCiudades.add(ciudad4.getNombre()); //budapest

        //creo la estrategia:
        //seteo la ruta anteriormente creada.
        Estrategia estrategia = new Estrategia(listaCiudades);

        //la estrategia se encarga de manipular lo relacionado a la ruta del ladron
        //reparte las pistas a las ciudades correspondientes, segun la ruta.
        estrategia.aplicarEstrategia(ciudadesjuego, pistasCiudades, ladron, mapa);

        //cada objeto tiene una estrategia.
        Objeto objeto = new Objeto("Huevo de 1000 años", estrategia);

        ArrayList<Objeto> objetosComunes = new ArrayList<>();
        objetosComunes.add(objeto);

        //el juego tiene un diccionario en donde se encuentran clasificados los objetos
        //esto permite que se repartan mas facilmente, segun el rango del jugador y
        //que LOS OBJETOS SE CREEN UNA SOLA VEZ.
        Map<String, ArrayList<Objeto>> objetos = new HashMap<>();
        objetos.put("Comun", objetosComunes);

        //**************carga del diccionario de objetos por tipo en el juego.
        juego.setObjetos(objetos);

//*******************************JUGADORES************************************

        //el juego tiene la capadcidad de recordar los jugadores que se crearon
        //estos jugadores se guardan en un diccionario.
        Map<String, Jugador> jugadores = new HashMap<>();

        //se chequea si el nombre ingresado de jugador, existe en el diccionario
        //si no, se crea de  nuevo.
        juego.setJugadores(jugadores);

        //Comienza el juego!
        Jugador jugador = juego.IdentificarJugador("Lucio");


        //LA EXECPCION SE LANZA POR SI SE INICIA UN CASO SIN UN JUGADOR.
        //desde la interfaz actual, esto no pasa nunca, pero el modelo esta preparado.
        try {
            juego.comenzarCaso();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Ciudad> destinos;

        //ya estan cargados todos los objetos necesarios para la prueba.
        //viajo hasta quedarme sin horas.
        int i;
        int viajes = 37;

        for (i = 0; i < viajes; i++) {
            //se obtienen los destinos disponibles para viajar.
            destinos = jugador.obtenerSiguientesDestinos();

            //ciudad de mexico -> pekin -> bangkok -> (budapest <-> bangkok)
            if (i % 2 == 0)
                jugador.viajarACiudad(destinos.get(0));
            else
                jugador.viajarACiudad(destinos.get(1));
        }

        assert(jugador.terminarJuego()); //el jugador se queda sin horas, entonces pierde.
        //es un metodo que depende de reloj ->
    }


    //test integracion con carga de archivos.
    @Test
    public void elJugadorSeQuedaSinHorasEntoncesPierdeElJuego() {

//***********************Version de Integración / Lo que se ejecutaria en la interfaz*************************

        //patron fachada
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);

        //patron builder de juego
        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        try{
            director.crearJuego(fachada);
        }catch(Exception e){
            e.printStackTrace();
        }

        Juego juego = director.obtenerJuego();

        //comienzo del juego
        Jugador jugador = juego.IdentificarJugador("Lucio");

        try {
            juego.comenzarCaso();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Ciudad> destinos;

        //viajo hasta quedarme sin horas
        int viajes = 38;
        for (int i = 0; i < viajes; i++) {
            //se obtienen los destinos disponibles
            destinos = jugador.obtenerSiguientesDestinos();

            jugador.viajarACiudad(destinos.get(0)); //las cuidades están conectadas, como un grafo dirigido.
        }

        assert(jugador.terminarJuego());
    }










}
