package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.CiudadesMapa;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaz;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MapaTest {

    @Test
    public void seMuestranLas_4_CiudadesCorrectasDeLaCiudadEnElTurno(){

        Mapa mapa;
        CiudadesMapa ciudadesMapa;
        Ciudad ciudad1 = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        Ciudad ciudad3 = new Ciudad();
        Ciudad ciudad4 = new Ciudad();

        Ciudad ciudad5 = new Ciudad();
        Ciudad ciudad6 = new Ciudad();
        Ciudad ciudad7 = new Ciudad();

        ciudad1.setNombre("Montreal");
        ciudad2.setNombre("Mexico");
        ciudad3.setNombre("Buenos Aires");
        ciudad4.setNombre("Pekin");

        ciudad5.setNombre("Bagdad");
        ciudad6.setNombre("Cancun");
        ciudad7.setNombre("Brasil");

        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(ciudad1);

        //estas las agrego para probar que se le devuelve la ciudad correcta al mapa.
        ciudades.add(ciudad5);
        ciudades.add(ciudad6);
        ciudades.add(ciudad7);

        ciudad1.setCiudadConexion(ciudad2);
        ciudad1.setCiudadConexion(ciudad3);
        ciudad1.setCiudadConexion(ciudad4);

        //cargo las ciudades:
        ciudadesMapa = new CiudadesMapa(ciudades);

        //creo el mapa
        mapa = new Mapa(ciudadesMapa);

        //cargo las ciudades a mostrar en el turno:
        mapa.cargarCiudades(ciudad1);

        ArrayList<Ciudad> mostradas = mapa.getCiudadesDisponibles();

        assert(mostradas.get(0).getNombre().equals("Montreal"));
        assert(mostradas.get(1).getNombre().equals("Mexico"));
        assert(mostradas.get(2).getNombre().equals("Buenos Aires"));
        assert(mostradas.get(3).getNombre().equals("Pekin"));
    }

/*
    @Test
    public void dadaUnaCiudadDelMapaElJugadorRealizaUnViaje(){

        Mapa mapa;
        Jugador jugador;
        CiudadesMapa ciudadesMapa;
        Ciudad ciudad1 = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        Ciudad ciudad3 = new Ciudad();
        Ciudad ciudad4 = new Ciudad();

        Ciudad ciudad5 = new Ciudad();
        Ciudad ciudad6 = new Ciudad();
        Ciudad ciudad7 = new Ciudad();

        ciudad1.setNombre("Montreal");
        ciudad1.setCoordenadas("45.50884","-73.58781");

        ciudad2.setNombre("Mexico");
        ciudad1.setCoordenadas("23.634501","-102.552784");

        ciudad3.setNombre("Buenos Aires");
        ciudad1.setCoordenadas("-34.6083","-58.3712");

        ciudad4.setNombre("Pekin");
        ciudad1.setCoordenadas("39.9035","116.388");

        ciudad5.setNombre("Bagdad");
        ciudad6.setNombre("Cancun");
        ciudad7.setNombre("Brasil");

        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(ciudad1);

        //estas las agrego para probar que se le devuelve la ciudad correcta al mapa.
        ciudades.add(ciudad5);
        ciudades.add(ciudad6);
        ciudades.add(ciudad7);

        ciudad1.setCiudadConexion(ciudad2);
        ciudad1.setCiudadConexion(ciudad3);
        ciudad1.setCiudadConexion(ciudad4);

        //cargo las ciudades:
        ciudadesMapa = new CiudadesMapa(ciudades);

        //creo el mapa
        mapa = new Mapa(ciudadesMapa);

        //cargo las ciudades a mostrar en el turno:
        mapa.cargarCiudades(ciudad1);

        jugador = new Jugador("alejo", 0);

        ArrayList<String> mostradas = mapa.getCiudadesDisponibles();
        Ciudad proxima = mapa.getCiudad(mostradas.get(1)); //Buenos aires

        //creo lo relativo al caso para empezar una partida...

        //***************
        String leido = "{  \"Merey Laroc\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Tenis\",    \"Cabello\" : \"Rojo\",    \"Senia\" : \"Tatuaje\",    \"Vehiculo\" : \"Deportivo\"  },  " +
                "\"Carmen SanDiego\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Croquet\",    \"Cabello\" : \"Negro\",    \"Senia\" : \"Joyas\",    \"Vehiculo\" : \"Limusina\"  }}";

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");

        ArrayList<String> valores_sospechoso = new ArrayList<>();
        valores_sospechoso.add("Femenino");
        valores_sospechoso.add("Tenis");

        Sospechosos sospechosos = new Sospechosos(leido);
        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores_sospechoso);

        assert(obtenidos.get(0).equals("Merey Laroc"));

        //******Creo lo necesario para crea el caso:******

        Ladron ladron = new Ladron();
        ladron.setSexo(valores_sospechoso.get(0));
        ladron.setHobby(valores_sospechoso.get(1));


        Secuaz secuaz1 = new Secuaz("Merey Laroc");
        secuaz1.setSexo(valores_sospechoso.get(0));
        secuaz1.setHobby(valores_sospechoso.get(1));

        Objeto objeto = new Objeto();
        objeto.setNombre("Lican Gold Mask");
        objeto.setOrigen("Montreal");
        objeto.setValor("Comun");

        //Necesito al menos 4 ciudades.
        String ciudadesLeidas = "{\n" +
                "  \"Montreal\":{\n" +
                "    \"latitud\": \"45.50884\",\n" +
                "    \"longitud\": \"-73.58781\",\n" +
                "    \"descripcion\": \"Ciudad de montreal\"\n" +
                "  },\n" +
                "  \"Mexico\":{\n" +
                "    \"latitud\": \"23.634501\",\n" +
                "    \"longitud\": \"-102.552784\",\n" +
                "    \"descripcion\": \"Ciudad de mexico\"\n" +
                "  },\n" +
                "  \"Buenos Aires\":{\n" +
                "    \"latitud\": \"-34.6083\",\n" +
                "    \"longitud\": \"-58.3712\",\n" +
                "    \"descripcion\": \"Ciudad de Buenos Aires\"\n" +
                "  },\n" +
                "  \"Pekin\":{\n" +
                "    \"latitud\": \"39.9035\",\n" +
                "    \"longitud\": \"116.388\",\n" +
                "    \"descripcion\": \"Ciudad de Pekin\"\n" +
                "  }}";

        Ciudades ciudadesArchivo = new Ciudades(ciudadesLeidas);

        jugador.empezarCaso(ladron, objeto, ciudad1, ciudadesArchivo, sospechosos );
        jugador.viajarACiudad(proxima);
    }
 */

}
