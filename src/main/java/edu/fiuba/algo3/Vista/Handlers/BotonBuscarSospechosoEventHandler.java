package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class BotonBuscarSospechosoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    ListView listView;
    Button boton;
    public BotonBuscarSospechosoEventHandler(Jugador jugador, ListView listView, Button boton){
        this.jugador = jugador;
        this.listView = listView;
        this.boton = boton;
    }

    public void handle(ActionEvent actionEvent){

        ArrayList<String> sospechosos = jugador.buscarSospechosos();
        for (String sospechoso: sospechosos) {
            listView.getItems().add(sospechoso);
        }

    }
}
