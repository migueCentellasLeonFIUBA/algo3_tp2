package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonViajarADestinoEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonVolverEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverEnterEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverExitEventHandler;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;


public class LayoutViajar extends Pane {

    Jugador jugador;
    VBox rightSide;
    Stage stage;

    public LayoutViajar(Jugador jugador, VBox rightSide, Stage stage){

        this.jugador = jugador;
        this.rightSide = rightSide;
        this.stage = stage;

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);

        VBox botones = crearBotones();

        Label viajar = new Label("VER CONEXIONES");
        viajar.setTranslateY(-480);
        viajar.setTranslateX(90);
        viajar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));
        viajar.setTextFill(Color.BLACK);

        Button volver = new Button("Volver");
        volver.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));

        volver.setTranslateY(-90);
        volver.setTranslateX(10);
        volver.setBackground(grisClaro);
        volver.setPrefHeight(70);
        volver.setPrefWidth(400);

        MouseHoverEnterEventHandler mouseHoverEventHandlerVolver = new MouseHoverEnterEventHandler(volver);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerVolver = new MouseHoverExitEventHandler(volver);
        volver.setOnMouseEntered(mouseHoverEventHandlerVolver);
        volver.setOnMouseExited(mouseHoverExitEventHandlerVolver);


        BotonVolverEventHandler botonVolverEventHandler = new BotonVolverEventHandler(stage, jugador);
        volver.setOnAction(botonVolverEventHandler);

        this.getChildren().addAll(viajar, botones, volver);
        rightSide.getChildren().add(this);

    }

    private VBox crearBotones(){

        ArrayList<Ciudad> posiblesDestinos = jugador.obtenerSiguientesDestinos();
        VBox botones = new VBox();

        botones.setLayoutX(120);
        botones.setLayoutY(-240);
        botones.setSpacing(1);

        ArrayList<Ciudad> conexiones = jugador.verConexiones();

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);

        Button destinoUno = new Button((posiblesDestinos.get(0).getNombre()));
        BotonViajarADestinoEventHandler botonViajarADestinoUnoEventHandler = new BotonViajarADestinoEventHandler(jugador, stage, posiblesDestinos.get(0));
        destinoUno.setOnAction(botonViajarADestinoUnoEventHandler);
        destinoUno.setBackground(grisClaro);
        destinoUno.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));

        destinoUno.setPrefWidth(400);
        destinoUno.setPrefHeight(40);
        destinoUno.setTranslateX(-100);

        destinoUno.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerDestinoUno = new MouseHoverEnterEventHandler(destinoUno);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerDestinoUno = new MouseHoverExitEventHandler(destinoUno);
        destinoUno.setOnMouseEntered(mouseHoverEventHandlerDestinoUno);
        destinoUno.setOnMouseExited(mouseHoverExitEventHandlerDestinoUno);

        Button destinoDos = new Button((posiblesDestinos.get(1).getNombre()));
        BotonViajarADestinoEventHandler botonViajarADestinoDosEventHandler = new BotonViajarADestinoEventHandler(jugador, stage, posiblesDestinos.get(1));
        destinoDos.setOnAction(botonViajarADestinoDosEventHandler);
        destinoDos.setBackground(grisClaro);
        destinoDos.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));

        destinoDos.setPrefWidth(400);
        destinoDos.setTranslateX(-100);

        destinoDos.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerDestinoDos = new MouseHoverEnterEventHandler(destinoDos);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerDestinoDos = new MouseHoverExitEventHandler(destinoDos);
        destinoDos.setOnMouseEntered(mouseHoverEventHandlerDestinoDos);
        destinoDos.setOnMouseExited(mouseHoverExitEventHandlerDestinoDos);

        Button destinoTres = new Button((posiblesDestinos.get(2).getNombre()));
        BotonViajarADestinoEventHandler botonViajarADestinoTresEventHandler = new BotonViajarADestinoEventHandler(jugador, stage, posiblesDestinos.get(2));
        destinoTres.setOnAction(botonViajarADestinoTresEventHandler);
        destinoTres.setBackground(grisClaro);
        destinoTres.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));

        destinoTres.setPrefWidth(400);
        destinoTres.setTranslateX(-100);

        destinoTres.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerDestinoTres = new MouseHoverEnterEventHandler(destinoTres);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerDestinoTres = new MouseHoverExitEventHandler(destinoTres);
        destinoTres.setOnMouseEntered(mouseHoverEventHandlerDestinoTres);
        destinoTres.setOnMouseExited(mouseHoverExitEventHandlerDestinoTres);

        botones.getChildren().addAll(destinoUno, destinoDos, destinoTres);

        return botones;
    }


}
