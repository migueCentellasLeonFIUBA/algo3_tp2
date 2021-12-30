package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonSalirEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonVolverAJugarEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverEnterEventHandler;
import edu.fiuba.algo3.Vista.Handlers.MouseHoverExitEventHandler;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EscenaTiempoTerminado extends HBox {

    Jugador jugador;
    Stage stage;
    VBox leftSide;
    VBox rightSide;

    public EscenaTiempoTerminado(Stage stage, Jugador jugador) throws FileNotFoundException {

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

        Label creditos = new Label("CREDITOS");
        creditos.setTranslateX(105);
        creditos.setTranslateY(-485);
        creditos.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        creditos.setTextAlignment(TextAlignment.CENTER);

        Text integrantes = new Text("Nicolás Carreño\n\nMiguel Centellas León\n\nNicolás Esteban Fernandez\n\nTomás Gonzalez Mongelós\n\nAlexis Ramos");
        integrantes.setTextAlignment(TextAlignment.CENTER);
        integrantes.setTranslateX(60);
        integrantes.setTranslateY(-400);
        integrantes.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));


        HBox botones = crearBotones();
        botones.setTranslateX(30);

        rightSide.getChildren().addAll(ups, label, botones);
        leftSide.getChildren().addAll(creditos, integrantes);

        this.getChildren().addAll(leftSide, rightSide);
    }

    private HBox crearBotones() throws FileNotFoundException {

        HBox botones = new HBox();
        botones.setSpacing(5);
        botones.setTranslateY(-10);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);


        InputStream streamSalir = new FileInputStream("src/main/resources/imagenes/Salir.jpg");
        Image imageSalir = new Image(streamSalir);
        ImageView imageViewSalir = new ImageView();
        imageViewSalir.setImage(imageSalir);
        imageViewSalir.setFitHeight(60);
        imageViewSalir.setFitWidth(75);

        Button salir = new Button("", imageViewSalir);
        salir.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        salir.setBackground(grisClaro);
        BotonSalirEventHandler botonSalir = new BotonSalirEventHandler(stage);
        salir.setOnAction(botonSalir);
        salir.setPrefHeight(50);
        salir.setPrefWidth((50));
        salir.setEffect(new InnerShadow());
        salir.setTranslateX(70);
        salir.setTranslateY(-265);

        MouseHoverEnterEventHandler mouseHoverEnterEventHandlerSalir = new MouseHoverEnterEventHandler(salir);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerSalir = new MouseHoverExitEventHandler((salir));
        salir.setOnMouseEntered(mouseHoverEnterEventHandlerSalir);
        salir.setOnMouseExited(mouseHoverExitEventHandlerSalir);

        InputStream streamReiniciar = new FileInputStream("src/main/resources/imagenes/ReiniciarEdit.jpg");
        Image imageReiniciar = new Image(streamReiniciar);
        ImageView imageViewReiniciar = new ImageView();
        imageViewReiniciar.setImage(imageReiniciar);
        imageViewReiniciar.setFitHeight(60);
        imageViewReiniciar.setFitWidth(75);

        Button reiniciar = new Button("", imageViewReiniciar);
        reiniciar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        reiniciar.setBackground(grisClaro);

        BotonVolverAJugarEventHandler botonReiniciar = new BotonVolverAJugarEventHandler(stage, jugador);
        reiniciar.setOnAction(botonReiniciar);
        //reiniciar.setPrefHeight(50);
        //reiniciar.setPrefWidth((50));
        reiniciar.setPrefHeight(30);
        reiniciar.setPrefWidth((30));
        reiniciar.setEffect(new InnerShadow());
        reiniciar.setTranslateX(70);
        reiniciar.setTranslateY(-265);

        MouseHoverEnterEventHandler mouseHoverEnterEventHandlerReiniciar = new MouseHoverEnterEventHandler(reiniciar);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerReiniciar = new MouseHoverExitEventHandler(reiniciar);
        reiniciar.setOnMouseEntered(mouseHoverEnterEventHandlerReiniciar);
        reiniciar.setOnMouseExited(mouseHoverExitEventHandlerReiniciar);

        botones.getChildren().addAll(salir, reiniciar);
        return botones;

    }
}

