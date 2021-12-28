package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonViajarADestinoEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonVolverEventHandler;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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

        VBox botones = crearBotones();

        Label viajar = new Label("VER CONEXIONES");
        viajar.setTranslateY(-480);
        viajar.setTranslateX(125);
        viajar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));
        viajar.setTextFill(Color.BLACK);

        Button volver = new Button("Volver");
        volver.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        //volver.setTranslateY(-270);
        //volver.setTranslateX(120);
        volver.setLayoutX(120);
        volver.setLayoutY(-90);

        volver.setBackground(grisOscuro);
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

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);

        Button destinoUno = new Button((posiblesDestinos.get(0).getNombre()));
        //BotonViajarADestinoEventHandler botonViajarADestinoUnoEventHandler = new BotonViajarADestinoEventHandler(jugador, hbox, stage, posiblesDestinos.get(0));
        //destinoUno.setOnAction(botonViajarADestinoUnoEventHandler);
        destinoUno.setBackground(grisOscuro);
        destinoUno.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));

        Button destinoDos = new Button((posiblesDestinos.get(1).getNombre()));
        //BotonViajarADestinoEventHandler botonViajarADestinoDosEventHandler = new BotonViajarADestinoEventHandler(jugador, hbox, stage, posiblesDestinos.get(1));
        //destinoDos.setOnAction(botonViajarADestinoDosEventHandler);
        destinoDos.setBackground(grisOscuro);
        destinoDos.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));

        Button destinoTres = new Button((posiblesDestinos.get(2).getNombre()));
        //BotonViajarADestinoEventHandler botonViajarADestinoTresEventHandler = new BotonViajarADestinoEventHandler(jugador, hbox, stage, posiblesDestinos.get(2));
        //destinoTres.setOnAction(botonViajarADestinoTresEventHandler);
        destinoTres.setBackground(grisOscuro);
        destinoTres.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));

        botones.getChildren().addAll(destinoUno, destinoDos, destinoTres);

        return botones;
    }


}
