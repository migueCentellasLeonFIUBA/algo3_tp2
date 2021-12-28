package edu.fiuba.algo3.architecture.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.juego.Juego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ComputadoraTest {

    @Test
    public void TestComputadoraSinParametrosDevuelveTodosLosSospechoso() throws FileNotFoundException {

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Computadora computadora = new Computadora(sospechosos);

        ArrayList<String> sospechososFiltrados = computadora.BuscarSospechoso();


        Assertions.assertEquals(2, sospechososFiltrados.size());
    }

    @Test
    public void TestRuedaDeCaracteristicasFuncionaCorrectamente() throws FileNotFoundException {
        Integer cantSexos;
        Integer cantCabellos;
        Integer cantHobbys;
        Integer cantVehiculos;
        Integer cantSenias ;

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Computadora computadora = new Computadora(sospechosos);

        for(cantSexos = 3; cantSexos > 0; cantSexos--){
            computadora.siguienteSexo();
        }

        for(cantCabellos = 5; cantCabellos > 0; cantCabellos--){
            computadora.siguienteCabello();
        }

        for(cantHobbys = 7; cantHobbys > 0; cantHobbys--){
            computadora.siguienteHobby();
        }

        for(cantVehiculos = 5; cantVehiculos > 0; cantVehiculos--){
            computadora.siguienteVehiculo();
        }

        for(cantSenias = 5; cantSenias > 0; cantSenias--){
            computadora.siguienteSenia();
        }

    }

    @Test
    public void TestSiSeTienenTodosLosParametrosSeDevuelveUnSospechoso() throws FileNotFoundException {
        Integer hobby = 6;
        Integer cabello = 2;
        Integer vehiculo = 3;
        Integer senia = 3;

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Computadora computadora = new Computadora(sospechosos);

        int tenis = 6;
        int rojo = 2;
        int deportivo = 3;
        int tatuaje = 3;
        /*
         "Merey Laroc":{
            "Sexo": "Femenino",
            "Hobby" : "Tenis",
            "Cabello" : "Rojo",
            "Senia" : "Tatuaje",
            "Vehiculo" : "Deportivo"
          },
         */
        //SETEO SEXO
        computadora.siguienteSexo(); //femenino

        //SETEO HOBBY
        for (hobby = tenis; hobby > 0; hobby--) {
            computadora.siguienteHobby();
        }

        //SETEO CABELLO
        for (cabello = rojo; cabello > 0; cabello--) {
            computadora.siguienteCabello();
        }

        //SETEO VEHICULO
        for (vehiculo = deportivo; vehiculo > 0; vehiculo--) {
            computadora.siguienteVehiculo();
        }

        //SETEO SEÑA
        for (senia = tatuaje; senia > 0; senia--) {
            computadora.siguienteSenia();
        }

        ArrayList<String> sospechosoFiltrados = computadora.BuscarSospechoso();
        Assertions.assertEquals(1, sospechosoFiltrados.size());
        Assertions.assertEquals("Merey Laroc", sospechosoFiltrados.get(0));

    }

        @Test
        public void TestComputadoraConParametrosErroneosNoDevuelveSospechosos() throws FileNotFoundException {
            Integer hobby = 1;
            Integer cabello = 1;
            Integer vehiculo = 1;
            Integer senia = 1;

            GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
            Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
            Computadora computadora = new Computadora(sospechosos);

            int alpinismo = 1;
            int castaño = 1;
            int moto = 1;
            int joyas = 1;
        /*
         Sospechoso Inexistente:{
            "Sexo": "Femenino",
            "Hobby" : "Alpinismo",
            "Cabello" : "Castaño",
            "Senia" : "Joyas",
            "Vehiculo" : "Moto"
          },
         */
            //SETEO SEXO
            computadora.siguienteSexo(); //femenino

            //SETEO HOBBY
            computadora.siguienteHobby();


            //SETEO CABELLO
            computadora.siguienteCabello();

            //SETEO VEHICULO
            computadora.siguienteVehiculo();

            //SETEO SEÑA
            computadora.siguienteSenia();

            ArrayList<String> sospechosoFiltrados = computadora.BuscarSospechoso();
            Assertions.assertEquals(0, sospechosoFiltrados.size());
        }

    }


