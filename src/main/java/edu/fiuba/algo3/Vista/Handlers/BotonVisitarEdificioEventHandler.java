package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class BotonVisitarEdificioEventHandler implements EventHandler<ActionEvent> {

    Edificio edificio;
    Jugador jugador;
    VBox rightSide;

    public BotonVisitarEdificioEventHandler(Edificio edificio, Jugador jugador, VBox rightSide){
        this.edificio = edificio;
        this.jugador = jugador;
        this.rightSide = rightSide;
    }

    public void handle(ActionEvent actionEvent) {

        String pista = null;
        try {
            pista = jugador.visitarEdificio(edificio);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
