package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonSiguienteSexoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    Label label;
    public BotonSiguienteSexoEventHandler(Jugador jugador, Label label){
        this.jugador = jugador;
        this.label = label;
    }

    public void handle(ActionEvent actionEvent){

        jugador.siguienteSexo();
        label.setText(jugador.getSexoComputadora());

    }
}
