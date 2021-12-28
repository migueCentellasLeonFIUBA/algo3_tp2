package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonVisitarEdificioEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonVolverEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverEnterEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverExitEventHandler;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

//public class LayoutInvestigar extends VBox {
public class LayoutInvestigar extends Pane{
    Jugador jugador;
    Stage stage;

    public LayoutInvestigar(Jugador jugador, VBox rightSide, Stage stage){

        this.jugador = jugador;
        this.stage = stage;

        VBox botones = crearBotones(rightSide);
        //rightSide.setFillWidth(true);
        //rightSide.setViewOrder(2);
        //rightSide.setScaleShape(true);
        //rightSide.setSnapToPixel(true);


        Label investigar = new Label("INVESTIGAR");
        investigar.setTranslateY(-480);
        investigar.setTranslateX(130);
        investigar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));
        investigar.setTextFill(Color.BLACK);

        Text pista = new Text("Piloto: estoy seguro de haberle oído decir que quería nadar en el Río De La Plata, ¡Llevaba un traje de baño de lo más feo!");
        pista.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        pista.setWrappingWidth(400);

        pista.setTranslateY(-400);
        pista.setTranslateX(20);

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);


        Button volver = new Button("Volver");
        volver.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));

        volver.setTranslateY(-90);
        volver.setTranslateX(10);
        volver.setBackground(grisClaro);
        //volver.setMaxHeight(350);
        //volver.setMaxWidth(400);
        //volver.setMaxHeight(350);
        //volver.setMaxWidth(800);
        //volver.maxWidth(1000);
        volver.setPrefWidth(400);
        volver.setPrefHeight(60);
        volver.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerVolver = new MouseHoverEnterEventHandler(volver);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerVolver = new MouseHoverExitEventHandler(volver);
        volver.setOnMouseEntered(mouseHoverEventHandlerVolver);
        volver.setOnMouseExited(mouseHoverExitEventHandlerVolver);

        BotonVolverEventHandler botonVolverEventHandler = new BotonVolverEventHandler(stage, jugador);
        volver.setOnAction(botonVolverEventHandler);

        this.getChildren().addAll(investigar, pista, botones, volver);
        //rightSide.getChildren().addAll(investigar, pista, botones, volver);
        rightSide.getChildren().addAll(this);



    }

    private VBox crearBotones(VBox rightSide){

        VBox vbox = new VBox();

        //vbox.setTranslateX(120);
        //vbox.setTranslateY(-300);

        vbox.setLayoutX(120);
        vbox.setLayoutY(-250);
        vbox.setSpacing(1);

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);

        Button aeropuerto = new Button("Visitar Aeropuerto");
        //BotonVisitarEdificioEventHandler botonAeropuertoHandler = new BotonVisitarEdificioEventHandler(new AeroPuerto(), jugador, pista);
        //aeropuerto.setOnAction(botonAeropuertoHandler);

        aeropuerto.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        aeropuerto.setBackground(grisOscuro);
        aeropuerto.setTextAlignment(TextAlignment.CENTER);

        aeropuerto.setTranslateX(-100);
        aeropuerto.setBackground(grisClaro);
        //aeropuerto.setMaxHeight(350);
        aeropuerto.setPrefWidth(400);
        aeropuerto.setPrefHeight(40);
        aeropuerto.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerAeropuerto = new MouseHoverEnterEventHandler(aeropuerto);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerAeropuerto = new MouseHoverExitEventHandler(aeropuerto);
        aeropuerto.setOnMouseEntered(mouseHoverEventHandlerAeropuerto);
        aeropuerto.setOnMouseExited(mouseHoverExitEventHandlerAeropuerto);

        Button banco = new Button("Visitar Banco");

        //BotonVisitarEdificioEventHandler botonBancoHandler = new BotonVisitarEdificioEventHandler(new Banco(), jugador, rightSide);
        //banco.setOnAction(botonBancoHandler);
        banco.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        banco.setBackground(grisClaro);
        banco.setTextAlignment(TextAlignment.CENTER);
        banco.setPrefWidth(400);
        banco.setTranslateX(-100);
        banco.setPrefHeight(40);
        banco.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerBanco = new MouseHoverEnterEventHandler(banco);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerBanco = new MouseHoverExitEventHandler(banco);
        banco.setOnMouseEntered(mouseHoverEventHandlerBanco);
        banco.setOnMouseExited(mouseHoverExitEventHandlerBanco);

        Button biblioteca = new Button("Visitar Biblioteca");
        //BotonVisitarEdificioEventHandler botonBibliotecaHandler = new BotonVisitarEdificioEventHandler(new Biblioteca(), jugador, pista);
        //biblioteca.setOnAction(botonBibliotecaHandler);
        biblioteca.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        biblioteca.setBackground(grisClaro);
        biblioteca.setTextAlignment(TextAlignment.CENTER);
        biblioteca.setEffect(new InnerShadow());
        biblioteca.setPrefHeight(40);

        biblioteca.setPrefWidth(400);
        biblioteca.setTranslateX(-100);

        MouseHoverEnterEventHandler mouseHoverEventHandlerBiblioteca = new MouseHoverEnterEventHandler(biblioteca);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerBiblioteca = new MouseHoverExitEventHandler(biblioteca);
        biblioteca.setOnMouseEntered(mouseHoverEventHandlerBiblioteca);
        biblioteca.setOnMouseExited(mouseHoverExitEventHandlerBiblioteca);


        Button bolsa = new Button("Bolsa");
        BotonVisitarEdificioEventHandler botonBolsaHandler = new BotonVisitarEdificioEventHandler(new Bolsa(), jugador, rightSide);
        bolsa.setOnAction(botonBolsaHandler);

        Button puerto = new Button("Puerto");
        BotonVisitarEdificioEventHandler botonPuertoHandler = new BotonVisitarEdificioEventHandler(new Puerto(), jugador, rightSide);
        puerto.setOnAction(botonPuertoHandler);



        vbox.getChildren().addAll(aeropuerto, biblioteca, banco);
        return vbox;
    }
}
