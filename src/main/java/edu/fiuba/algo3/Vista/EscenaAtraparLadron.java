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

public class EscenaAtraparLadron extends HBox {

    Stage stage;
    VBox leftSide;
    Pane rightSide;
    Jugador jugador;

    public EscenaAtraparLadron(Stage stage, String pista, Jugador jugador) throws FileNotFoundException {

        this.stage = stage;
        this.jugador = jugador;


        this.setPadding(new Insets(30, 30, 30, 30));
        this.setSpacing(20);

        BackgroundFill fondoNegro = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background fondo = new Background(fondoNegro);
        this.setBackground(fondo);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);

        LayoutGeneral layoutGeneral = new LayoutGeneral();
        leftSide = layoutGeneral.crearLeftSide();
        rightSide = layoutGeneral.crearRightSide();

        Text text = new Text(pista);
        text.setTranslateX(10);
        text.setTranslateY(-350);
        text.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 19));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setWrappingWidth(400);

        Label casoFinalizado = new Label("CASO FINALIZADO");
        casoFinalizado.setTranslateX(100);
        casoFinalizado.setTranslateY(-450);
        casoFinalizado.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));
        casoFinalizado.setTextAlignment(TextAlignment.CENTER);


        /*Button salir = new Button("SALIR");
        salir.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        salir.setBackground(grisClaro);
        BotonSalirEventHandler botonSalir = new BotonSalirEventHandler(stage);
        salir.setOnAction(botonSalir);
        salir.setPrefHeight(300);
        salir.setPrefWidth((300));
        salir.setEffect(new InnerShadow());
        salir.setTranslateX(70);
        salir.setTranslateY(-210);
        //salir.setTranslateX(70);
        //salir.setLayoutY(100);

        MouseHoverEnterEventHandler mouseHoverEnterEventHandler = new MouseHoverEnterEventHandler(salir);
        MouseHoverExitEventHandler mouseHoverExitEventHandler = new MouseHoverExitEventHandler((salir));
        salir.setOnMouseEntered(mouseHoverEnterEventHandler);
        salir.setOnMouseExited(mouseHoverExitEventHandler);*/

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
        botones.setTranslateY(45);
        botones.setTranslateX(30);


        rightSide.getChildren().addAll(casoFinalizado, text, botones);
        leftSide.getChildren().addAll(creditos, integrantes);

        this.getChildren().addAll(leftSide, rightSide);

    }

    private HBox crearBotones() throws FileNotFoundException {

        HBox botones = new HBox();
        botones.setSpacing(5);
        botones.setTranslateY(-10);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);


        InputStream streamSalir = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\Salir.jpg");
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

        InputStream streamReiniciar = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\ReiniciarEdit.jpg");
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
