package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class BotonBuscarSospechosoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    VBox leftSide;

    public BotonBuscarSospechosoEventHandler(Jugador jugador, VBox leftSide){
        this.jugador = jugador;
        this.leftSide = leftSide;

    }

    public void handle(ActionEvent actionEvent){

        ArrayList<String> listaSospechosos = jugador.buscarSospechosos();
        String sospechosos = "";
        String texto = "";
        for (String sospechoso: listaSospechosos) {
            sospechosos = sospechosos + sospechoso + ", ";
        }

        if(sospechosos.length() != 0){
            texto = sospechosos.substring(0, sospechosos.length() - 2);
        }


        Text text = new Text(texto);
        text.setTranslateX(20);
        text.setTranslateY(-450);
        text.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));
        text.setFill(Color.BLACK);
        text.setWrappingWidth(400);

        Label tiempoRestante = new Label(jugador.diaYHora());
        tiempoRestante.setTranslateX(115);
        tiempoRestante.setTranslateY(-505);
        tiempoRestante.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));

        leftSide.getChildren().remove(3);
        leftSide.getChildren().add(3, tiempoRestante);

        leftSide.getChildren().remove(5);
        leftSide.getChildren().add(text);
    }
}
