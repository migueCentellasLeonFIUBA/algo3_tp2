package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EscenaAsignarCaso extends HBox {

    private Jugador jugador;
    private Stage stage;
    private VBox leftSide;
    private VBox rightSide;

    public EscenaAsignarCaso(Stage stage, Jugador jugador) {

        this.stage = stage;
        this.jugador = jugador;

        LayoutGeneral layoutGeneral = new LayoutGeneral();
        leftSide = layoutGeneral.crearLeftSide();
        rightSide = layoutGeneral.crearRightSide();

        this.setPadding(new Insets(30, 30, 30, 30));
        this.setSpacing(20);

        BackgroundFill fondoNegro = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background fondo = new Background(fondoNegro);
        this.setBackground(fondo);

        rightSide = crearRightSide(rightSide);
        leftSide = crearLeftSide(leftSide);


        this.getChildren().addAll(leftSide, rightSide);

    }

    public VBox crearRightSide(VBox rightSide){

        rightSide.setSpacing(10);
        rightSide.setMaxWidth(420);
        rightSide.setMaxHeight(600);

        Label presioneEnter = new Label("Presione 'Enter'");
        presioneEnter.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));
        presioneEnter.setTranslateX(65);
        presioneEnter.setTranslateY(-70);

        /*Button boton = new Button();
        boton.setVisible(true);
        EnterEscenaAsignarCasoEventHandler siguiente = new EnterEscenaAsignarCasoEventHandler(this.stage, jugador, leftSide);
        boton.setOnKeyPressed(siguiente);*/

        rightSide.getChildren().add(presioneEnter);
        return rightSide;
    }

    public VBox crearLeftSide(VBox leftSide){

        leftSide.setSpacing(10);
        leftSide.setMaxWidth(420);
        leftSide.setMaxHeight(600);

        Label lugar = new Label("CUARTEL GENERAL");
        lugar.setTranslateX(90);
        lugar.setTranslateY(-495);
        lugar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));

        Label tiempoRestante = new Label("Lunes, 9 a.m.");
        tiempoRestante.setTranslateX(130);
        tiempoRestante.setTranslateY(-495);
        tiempoRestante.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));

        Text datosCaso = new Text();
        datosCaso.setText(jugador.getDescripcionCaso());
        datosCaso.setTranslateX(20);
        datosCaso.setTranslateY(-450);
        datosCaso.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        datosCaso.setFill(Color.BLACK);
        datosCaso.setWrappingWidth(400);

        //EnterEscenaAsignarCasoEventHandler siguiente = new EnterEscenaAsignarCasoEventHandler(this.stage, jugador, leftSide);
        //(this.stage.getScene()).setOnKeyPressed(siguiente);

        leftSide.getChildren().addAll(lugar, tiempoRestante, datosCaso);
        //leftSide.getChildren().addAll(lugar, tiempoRestante);
        return leftSide;

    }
}
