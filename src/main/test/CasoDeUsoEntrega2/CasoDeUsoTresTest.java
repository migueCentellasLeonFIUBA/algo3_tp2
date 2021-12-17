package CasoDeUsoEntrega2;

import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasoDeUsoTresTest {

    @Test
    public void TestComputadoraBuscaSospechosos() throws FileNotFoundException {

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Computadora computadora = new Computadora(sospechosos);

        Integer hobby = 2;
        Integer cabello = 3;
        Integer vehiculo = 2;
        Integer senia = 1;

        int croquet = 2;
        int negro = 3;
        int limusina = 2;
        int joyas = 1;

        /*
         "Carmen Sandiego":{
            "Sexo": "Femenino",
            "Hobby" : "Croquet",
            "Cabello" : "Negro",
            "Senia" : "Joyas",
            "Vehiculo" : "Limusina"
          },
         */

        //SETEO SEXO
        computadora.siguienteSexo(); //femenino

        //SETEO HOBBY
        for(hobby = croquet; hobby > 0; hobby--){
            computadora.siguienteHobby();
        }

        //SETEO CABELLO
        for(cabello = negro; cabello > 0; cabello--){
            computadora.siguienteCabello();
        }

        //SETEO VEHICULO
        for(vehiculo = limusina; vehiculo > 0; vehiculo--){
            computadora.siguienteVehiculo();
        }

        //SETEO SEÑA
        for(senia = joyas; senia > 0; senia--){
            computadora.siguienteSenia();
        }

        ArrayList<String> sospechosoFiltrados = computadora.BuscarSospechoso();
        assertEquals(1, sospechosoFiltrados.size());
        assertEquals("Carmen Sandiego", sospechosoFiltrados.get(0));

    }



}
