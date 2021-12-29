package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonSalirEventHandler(Stage stage){
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
        stage.close();
    }
}
