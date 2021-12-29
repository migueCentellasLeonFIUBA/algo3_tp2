package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonSalirEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverEnterEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverExitEventHandler;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class EscenaTiempoTerminado extends HBox {

    Jugador jugador;
    Stage stage;
    VBox leftSide;
    VBox rightSide;

    public EscenaTiempoTerminado(Stage stage){

        this.jugador = jugador;
        this.stage = stage;


        this.setPadding(new Insets(30, 30, 30, 30));
        this.setSpacing(20);

        BackgroundFill fondoNegro = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background fondo = new Background(fondoNegro);
        this.setBackground(fondo);


        LayoutGeneral layoutGeneral = new LayoutGeneral();
        leftSide = layoutGeneral.crearLeftSide();
        rightSide = layoutGeneral.crearRightSide();

        Label ups = new Label("¡Ups!");
        ups.setTranslateX(150);
        ups.setTranslateY(-450);
        ups.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        ups.setTextAlignment(TextAlignment.CENTER);


        Text label = new Text("¡Te has quedado sin tiempo!\n\nsuerte en su próximo caso detective\n\nhasta la proxima");
        label.setTranslateX(10);
        label.setTranslateY(-300);
        label.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 19));
        label.setTextAlignment(TextAlignment.CENTER);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);

        Button salir = new Button("SALIR");
        salir.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        salir.setBackground(grisClaro);
        BotonSalirEventHandler botonSalir = new BotonSalirEventHandler(stage);
        salir.setOnAction(botonSalir);
        salir.setPrefHeight(300);
        salir.setPrefWidth((300));
        salir.setEffect(new InnerShadow());
        salir.setTranslateX(70);
        salir.setTranslateY(-265);

        MouseHoverEnterEventHandler mouseHoverEnterEventHandler = new MouseHoverEnterEventHandler(salir);
        MouseHoverExitEventHandler mouseHoverExitEventHandler = new MouseHoverExitEventHandler((salir));
        salir.setOnMouseEntered(mouseHoverEnterEventHandler);
        salir.setOnMouseExited(mouseHoverExitEventHandler);

        rightSide.getChildren().addAll(ups, label, salir);
        //leftSide.getChildren().add();

        this.getChildren().addAll(leftSide, rightSide);
    }
}
