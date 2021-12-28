package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LayoutIzquierdoComputadora extends VBox {

    public LayoutIzquierdoComputadora(Jugador jugador, VBox leftSide){

        Label sospechosos = new Label("SOSPECHOSOS");
        sospechosos.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));
        //sospechosos.setTextFill(Color.BLACK);
        sospechosos.setTranslateY(-450);
        sospechosos.setTranslateX(120);

        Text text = new Text("");


        leftSide.getChildren().addAll(sospechosos, text);
    }
}
