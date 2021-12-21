package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class BotonVisitarEdificioEventHandler implements EventHandler<ActionEvent> {

    Edificio edificio;
    Jugador jugador;
    Label label;

    public BotonVisitarEdificioEventHandler(Edificio edificio, Jugador jugador, Label label){
        this.edificio = edificio;
        this.jugador = jugador;
        this.label = label;
    }

    public void handle(ActionEvent actionEvent) {

        String pista = null;
        try {
            pista = jugador.visitarEdificio(edificio);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        label.setText(pista);


    }
}
