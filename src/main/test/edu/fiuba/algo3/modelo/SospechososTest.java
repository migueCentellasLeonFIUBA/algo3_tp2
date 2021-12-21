package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Ciudades;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Secuaz;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
SUPUESTOS convenientes:
    *  ) Para encontrar a un ladron, se necesitan todos ,o casi todos, los datos correctos.
    *  ) Todos los sospechosos pueden tener distintos datos entre si, es decir, no puede haber dos con los mismos valores.
    *  ) Se puede usar la misma lista de sospechosos en todos los casos, sólo cambia el ladron que es random.
 */

public class SospechososTest {

    @Test
    public void losDatosDeUnLadronEncuentranAUnSospechoso(){

        String leido = "{\"Merey Laroc\":{ \"Sexo\": \"Femenino\",\"Hobby\" : \"Escalar Montanias\", \"Cabello\" : \"Marron\", \"Senia\" : \"Joyas\", \"Vehiculo\" : \"Limosina\" }}";

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");
        valores.add("Escalar Montanias");

        Sospechosos sospechosos = new Sospechosos(leido);
        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores);

        assert(obtenidos.get(0).equals("Merey Laroc"));
    }

    @Test
    public void losDatosDeUnLadronEncuentranSospechosos() throws FileNotFoundException {

        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();

        leido = gestorArchivos.leerTextoCompleto(ruta);

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");

        assert(leido.contains("Merey Laroc"));
        assert(leido.contains("Carmen Sandiego"));

        //System.out.println(leido);
        Sospechosos sospechosos = new Sospechosos(leido);

        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores);

        assert(obtenidos.get(0).equals("Merey Laroc"));
        assert(obtenidos.get(1).equals("Carmen Sandiego"));
    }

    @Test
    public void losDatosExactosDeUnLadronDejanUnSoloSospechosoQueEsElLadron() {

        /*
        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();
        leido = gestorArchivos.leerTextoCompleto(ruta);

        assert(leido.contains("Merey Laroc"));
        assert(leido.contains("Carmen Sandiego"));
        System.out.println(leido);
        */

        String leido = "{  \"Merey Laroc\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Tenis\",    \"Cabello\" : \"Rojo\",    \"Senia\" : \"Tatuaje\",    \"Vehiculo\" : \"Deportivo\"  },  " +
                "\"Carmen SanDiego\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Croquet\",    \"Cabello\" : \"Negro\",    \"Senia\" : \"Joyas\",    \"Vehiculo\" : \"Limusina\"  }}";

        //borrar
        assert(leido.contains("Merey Laroc"));
        assert(leido.contains("Carmen SanDiego"));

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");
        caracteristicas.add("Cabello");
        caracteristicas.add("Senia");
        caracteristicas.add("Vehiculo");

        ArrayList<String> valores = new ArrayList<>();
        valores.add("Femenino");
        valores.add("Tenis");
        valores.add("Rojo");
        valores.add("Tatuaje");
        valores.add("Deportivo");

        Sospechosos sospechosos = new Sospechosos(leido);
        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores);

        assert(obtenidos.get(0).equals("Merey Laroc"));
        assertEquals(1, obtenidos.size());
    }

    @Test
    public void conLosDatosDeSospechososDistintosEncuentroLadronesDistintos(){

        String leido = "{  \"Merey Laroc\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Tenis\",    \"Cabello\" : \"Rojo\",    \"Senia\" : \"Tatuaje\",    \"Vehiculo\" : \"Deportivo\"  },  " +
                "\"Carmen SanDiego\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Croquet\",    \"Cabello\" : \"Negro\",    \"Senia\" : \"Joyas\",    \"Vehiculo\" : \"Limusina\"  }}";

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");
        caracteristicas.add("Cabello");
        caracteristicas.add("Senia");
        caracteristicas.add("Vehiculo");

        ArrayList<String> valores_ladron = new ArrayList<>();
        valores_ladron.add("Femenino");
        valores_ladron.add("Croquet");
        valores_ladron.add("Negro");
        valores_ladron.add("Joyas");
        valores_ladron.add("Limusina");

        ArrayList<String> valores_sospechoso = new ArrayList<>();
        valores_sospechoso.add("Femenino");
        valores_sospechoso.add("Tenis");
        valores_sospechoso.add("Rojo");
        valores_sospechoso.add("Tatuaje");
        valores_sospechoso.add("Deportivo");

        Sospechosos sospechosos = new Sospechosos(leido);
        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores_sospechoso);

        assert(obtenidos.get(0).equals("Merey Laroc"));

        Sospechosos ladron = new Sospechosos(leido);
        ArrayList<String> ladron_obtenido = ladron.buscarSospechosos(caracteristicas, valores_ladron);

        assert(ladron_obtenido.get(0).equals("Carmen SanDiego"));
        assertEquals(1, ladron_obtenido.size());
    }

    @Test
    public void conLosDatosDeUnSospechosoEncuentroAlLadronDelCaso(){

        String leido = "{  \"Merey Laroc\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Tenis\",    \"Cabello\" : \"Rojo\",    \"Senia\" : \"Tatuaje\",    \"Vehiculo\" : \"Deportivo\"  },  " +
                "\"Carmen SanDiego\":{    \"Sexo\": \"Femenino\",    \"Hobby\" : \"Croquet\",    \"Cabello\" : \"Negro\",    \"Senia\" : \"Joyas\",    \"Vehiculo\" : \"Limusina\"  }}";

        ArrayList<String> caracteristicas= new ArrayList<>();
        caracteristicas.add("Sexo");
        caracteristicas.add("Hobby");
        caracteristicas.add("Cabello");
        caracteristicas.add("Senia");
        caracteristicas.add("Vehiculo");

        ArrayList<String> valores_sospechoso = new ArrayList<>();
        valores_sospechoso.add("Femenino");
        valores_sospechoso.add("Tenis");
        valores_sospechoso.add("Rojo");
        valores_sospechoso.add("Tatuaje");
        valores_sospechoso.add("Deportivo");

        Sospechosos sospechosos = new Sospechosos(leido);
        ArrayList<String> obtenidos = sospechosos.buscarSospechosos(caracteristicas, valores_sospechoso);

        assert(obtenidos.get(0).equals("Merey Laroc"));

        /*
        ArrayList<String> valores_ladron = new ArrayList<>();
        valores_ladron.add("Femenino");
        valores_ladron.add("Croquet");
        valores_ladron.add("Negro");
        valores_ladron.add("Joyas");
        valores_ladron.add("Limusina");

        Sospechosos ladron = new Sospechosos(leido);
        ArrayList<String> ladron_obtenido = ladron.buscarSospechosos(caracteristicas, valores_ladron);
        System.out.println(ladron_obtenido);

        assert(ladron_obtenido.get(0).equals("Carmen SanDiego"));
        assertEquals(1, ladron_obtenido.size());
         */

        //******Creo lo necesario para crea el caso:******

        Jugador jugador = new Jugador("Tito", 0);
        Ladron ladron = new Ladron();
        ladron.setSexo(valores_sospechoso.get(0));
        ladron.setHobby(valores_sospechoso.get(1));
        ladron.setCabello(valores_sospechoso.get(2));
        ladron.setSenia(valores_sospechoso.get(3));
        ladron.setVehiculo(valores_sospechoso.get(4));

        Secuaz secuaz1 = new Secuaz("Merey Laroc");
        secuaz1.setSexo(valores_sospechoso.get(0));
        secuaz1.setHobby(valores_sospechoso.get(1));
        secuaz1.setCabello(valores_sospechoso.get(2));
        secuaz1.setSenia(valores_sospechoso.get(3));
        secuaz1.setVehiculo(valores_sospechoso.get(4));

        Objeto objeto = new Objeto();
        objeto.setNombre("Lican Gold Mask");
        objeto.setOrigen("Oslo");
        objeto.setValor("Comun");

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Oslo");

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

        Ciudades ciudades = new Ciudades(ciudadesLeidas);

        //public void empezarCaso(Ladron ladron, Objeto objeto, Ciudad ciudad, Ciudades ciudades, Sospechosos sospechosos)
        jugador.empezarCaso(ladron, objeto, ciudad, ciudades, sospechosos );

        //No tengo una orden entonces:
            //No puedo arrestar sospechosos:
        assertNotEquals(true, jugador.arrestarLadron(secuaz1));

            //No puedo arrestar a un ladron:
        assertNotEquals(true, jugador.arrestarLadron(ladron));

        //Las pistas sólo me devuelven valores del ladron -> al buscar un sospechoso (como son todos distintos) el que queda es el ladron.
        //el ladron devuelve las pistas en el orden en que fueron colocadas entonces:

        ArrayList<String> pistasLadron = new ArrayList<>();
        pistasLadron.add(ladron.getPista());
        pistasLadron.add(ladron.getPista());
        pistasLadron.add(ladron.getPista());
        pistasLadron.add(ladron.getPista());
        pistasLadron.add(ladron.getPista());
        //sólo puede darme 5 pistas

        ArrayList<String> ladronEncontrado = jugador.buscarSospechosos(caracteristicas, pistasLadron);
        assertEquals(1, ladronEncontrado.size());

        //Como queda un solo sospechoso -> ese es el ladron, se emite la orden,
        //entonces ya puedo arrestarlo:
        assert(jugador.arrestarLadron(ladron));
    }
}
