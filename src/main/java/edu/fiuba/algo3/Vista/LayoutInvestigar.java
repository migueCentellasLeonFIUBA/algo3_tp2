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

    public LayoutInvestigar(Jugador jugador, VBox rightSide, Stage stage){

        this.jugador = jugador;

        VBox botones = crearBotones(rightSide);
        //rightSide.setFillWidth(true);
        //rightSide.setViewOrder(2);
        //rightSide.setScaleShape(true);
        //rightSide.setSnapToPixel(true);


        Label investigar = new Label("INVESTIGAR");
        investigar.setTranslateY(-480);
        investigar.setTranslateX(130);
        investigar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));
        investigar.setTextFill(Color.BLACK);

        Text pista = new Text("Pista fñuvhea ñuvhaeñi ufhvfña ghñiae urghñi ueahi");
        pista.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        pista.setWrappingWidth(400);

        pista.setTranslateY(-400);
        pista.setTranslateX(20);

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);


        Button volver = new Button("Volver");
        volver.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        //volver.setTranslateY(-270);
        //volver.setTranslateX(120);
        volver.setLayoutX(120);
        volver.setLayoutY(-90);
        MouseHoverEnterEventHandler mouseHoverEventHandlerVolver = new MouseHoverEnterEventHandler(volver);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerVolver = new MouseHoverExitEventHandler(volver);
        volver.setOnMouseEntered(mouseHoverEventHandlerVolver);
        volver.setOnMouseExited(mouseHoverExitEventHandlerVolver);

        volver.setBackground(grisOscuro);
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
        vbox.setLayoutY(-240);

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);

        Button aeropuerto = new Button("Visitar Aeropuerto");
        //BotonVisitarEdificioEventHandler botonAeropuertoHandler = new BotonVisitarEdificioEventHandler(new AeroPuerto(), jugador, pista);
        //aeropuerto.setOnAction(botonAeropuertoHandler);

        aeropuerto.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        aeropuerto.setBackground(grisOscuro);
        aeropuerto.setTextAlignment(TextAlignment.CENTER);

        Button banco = new Button("Visitar Banco");
        //BotonVisitarEdificioEventHandler botonBancoHandler = new BotonVisitarEdificioEventHandler(new Banco(), jugador, rightSide);
        //banco.setOnAction(botonBancoHandler);
        banco.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        banco.setBackground(grisOscuro);
        banco.setTextAlignment(TextAlignment.CENTER);

        Button biblioteca = new Button("Visitar Biblioteca");
        //BotonVisitarEdificioEventHandler botonBibliotecaHandler = new BotonVisitarEdificioEventHandler(new Biblioteca(), jugador, pista);
        //biblioteca.setOnAction(botonBibliotecaHandler);
        biblioteca.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        biblioteca.setBackground(grisOscuro);
        biblioteca.setTextAlignment(TextAlignment.CENTER);


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
