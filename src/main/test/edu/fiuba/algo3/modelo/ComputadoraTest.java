package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ComputadoraTest {

    @Test
    public void TestComputadoraSinParametrosDevuelveTodosLosSospechoso() throws FileNotFoundException {

    }

    @Test
    public void TestRuedaDeCaracteristicasFuncionaCorrectamente() throws FileNotFoundException {
        Integer cantSexos;
        Integer cantCabellos;
        Integer cantHobbys;
        Integer cantVehiculos;
        Integer cantSenias ;


    }

    @Test
    public void TestSiSeTienenTodosLosParametrosSeDevuelveUnSospechoso() throws FileNotFoundException {
        Integer hobby = 6;
        Integer cabello = 2;
        Integer vehiculo = 3;
        Integer senia = 3;


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

        //SETEO HOBBY
        for (hobby = tenis; hobby > 0; hobby--) {
        }

        //SETEO CABELLO
        for (cabello = rojo; cabello > 0; cabello--) {
        }

        //SETEO VEHICULO
        for (vehiculo = deportivo; vehiculo > 0; vehiculo--) {
        }

        //SETEO SEÑA
        for (senia = tatuaje; senia > 0; senia--) {
        }


    }

        @Test
        public void TestComputadoraConParametrosErroneosNoDevuelveSospechosos() throws FileNotFoundException {
            Integer hobby = 1;
            Integer cabello = 1;
            Integer vehiculo = 1;
            Integer senia = 1;
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
        }

    }


