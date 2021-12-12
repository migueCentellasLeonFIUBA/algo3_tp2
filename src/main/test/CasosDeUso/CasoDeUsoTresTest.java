package CasosDeUso;

import edu.fiuba.algo3.modelo.ciudades.*;
import edu.fiuba.algo3.modelo.jugador.*;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.rangos.Novato;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUsoTresTest {

    //Detective viaja de Montreal a México.
    @Test
    public void UnDetectiveViajaDeMontrealAMexicoYPierde_1_Hora(){
        int horas = 24;
        int velocidad = 900; //novato vel.

       Jugador jugador = new Jugador("juan", 0);
       Reloj reloj = new Reloj();
       reloj.setHorasRestantes(horas);
       jugador.setReloj(reloj);

       Coordenadas mexico = new Coordenadas(19.03, 98.57);
       Coordenadas montreal = new Coordenadas(45.50, -73.58);

       //700,6609 + 624,5001 = 1325,161 , raiz = 36.4027608843 -> horas = 1h
       Integer horasviaje = Math.round((float) 1325.161 /velocidad);

       Ciudad origen = new Ciudad();
       origen.setNombre("Montreal");
       origen.setCoordenadas(montreal);

       Ciudad destino = new Ciudad();
       destino.setCoordenadas(mexico);
       destino.setNombre("Mexico");

       jugador.setCiudadActual(origen);
       jugador.setGrado(new Novato());

       //ya se cargaron los objetos necesarios
        jugador.viajarACiudad(destino);
        assertEquals(horas - horasviaje, reloj.getHorasRestantes());

    }

}
