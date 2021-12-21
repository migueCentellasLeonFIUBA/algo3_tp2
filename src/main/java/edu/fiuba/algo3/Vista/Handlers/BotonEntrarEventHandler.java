package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Scene proximaEscena;
    Stage stage;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    public void handle(ActionEvent actionEvent){

        stage.setScene(proximaEscena);
    }
}
