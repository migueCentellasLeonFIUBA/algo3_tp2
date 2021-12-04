package CasosDeUso;

import edu.fiuba.algo3.modelo.ciudad.Coordenadas;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.*;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.PistaEconomica;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.objeto.Objeto;
import edu.fiuba.algo3.modelo.objeto.RarezaComun;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUsoTres {

    //Detective viaja de Montreal a México.
    @Test
    public void UnDetectiveViajaDeMontrealAMexicoYPierde_X_Horas(){
       Jugador jugador = Jugador.crearJugador("juan", 0);
       Reloj reloj = new Reloj();
       reloj.setHorasRestantes(30);

       Coordenadas mexico = new Coordenadas();
       mexico.setLatitud((float) 19.03);
       mexico.setLongitud((float) 98.57);

       Coordenadas montreal = new Coordenadas();
       montreal.setLatitud((float) 45.50);
       montreal.setLongitud((float) -73.58);

       Ciudad origen = new Ciudad("Montreal");
       origen.setCordenadas(montreal);
       Ciudad destino = new Ciudad("Mexico");
       origen.setCordenadas(mexico);



    }






}
