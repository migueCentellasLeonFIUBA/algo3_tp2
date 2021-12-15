package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Sospechosos;
import edu.fiuba.algo3.modelo.jugador.Computadora;
import edu.fiuba.algo3.modelo.juego.Juego;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ComputadoraTest {

    @Test
    public void TestComputadoraSinParametrosDevuelveTodosLosSospechosos() throws FileNotFoundException {

        GestorDeArchivos gestorDeArchivos = new GestorDeArchivos();
        Sospechosos sospechosos = new Sospechosos(gestorDeArchivos.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json"));
        Computadora computadora = new Computadora(sospechosos);

        ArrayList<String> sospechososFiltrados = computadora.BuscarSospechoso();


        assertEquals(2, sospechososFiltrados.size());
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
        //SETEO SEXO
        computadora.siguienteSexo();
        //SETEO HOBBY
        for(hobby = 6; hobby > 0; hobby--){
            computadora.siguienteHobby();
        }
        //SETEO CABELLO
        for(cabello = 2; cabello > 0; cabello--){
            computadora.siguienteCabello();
        }
        //SETEO VEHICULO
        for(vehiculo = 3; vehiculo > 0; vehiculo--){
            computadora.siguienteVehiculo();
        }
        //SETEO SEÑA
        for(senia = 3; senia > 0; senia--){
            computadora.siguienteSenia();
        }

        ArrayList<String> sospechosoFiltrados = computadora.BuscarSospechoso();
        assertEquals(1, sospechosoFiltrados.size());




    }
}

