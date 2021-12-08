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
        Integer horas = 24;
        Integer velocidad = 900; //novato vel.

       Jugador jugador = Jugador.crearJugador("juan", 0);
       Reloj reloj = new Reloj();
       reloj.setHorasRestantes(horas);
       jugador.setReloj(reloj);

       Coordenadas mexico = new Coordenadas();
       mexico.setLatitud((float) 19.03);
       mexico.setLongitud((float) 98.57);

       Coordenadas montreal = new Coordenadas();
       montreal.setLatitud((float) 45.50);
       montreal.setLongitud((float) -73.58);

       //700,6609 + 624,5001 = 1325,161 , raiz = 36.4027608843 -> horas = 1h
       Integer horasviaje = Math.round((float) 1325.161 / velocidad);

       Ciudad origen = Ciudad.crear("Montreal");
       origen.setCordenadas(montreal);

       Ciudad destino = Ciudad.crear("Mexico");
       destino.setCordenadas(mexico);

       jugador.setCiudadActual(origen);
       jugador.setGrado(new Novato());

       //ya se cargaron los objetos necesarios
        jugador.viajarACiudad(destino);
        assertEquals(horas - horasviaje, reloj.getHorasRestantes());

    }

}
