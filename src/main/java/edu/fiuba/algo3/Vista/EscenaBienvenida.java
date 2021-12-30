package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EscenaBienvenida extends HBox {

    Stage stage;
    VBox rightSide;
    VBox leftSide;
    Juego juego;

    public EscenaBienvenida(Stage stage, Juego juego) {
        super();

        this.stage = stage;
        this.juego = juego;

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

    private VBox crearLeftSide(VBox leftSide) {

        leftSide.setSpacing(10);
        leftSide.setMaxWidth(420);
        leftSide.setMaxHeight(600);

        Label lugar = new Label("CUARTEL GENERAL");
        lugar.setTranslateX(90);
        lugar.setTranslateY(-495);
        lugar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));

        Label tiempoRestante = new Label("Lunes, 8 hs");
        tiempoRestante.setTranslateX(130);
        tiempoRestante.setTranslateY(-495);
        tiempoRestante.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));

        Text mensajeBienvenida = new Text();
        mensajeBienvenida.setText("Bienvenido al cuartel general detective!, por favor identifiquese...");
        mensajeBienvenida.setTranslateX(20);
        mensajeBienvenida.setTranslateY(-450);
        mensajeBienvenida.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        mensajeBienvenida.setFill(Color.BLACK);
        mensajeBienvenida.setWrappingWidth(400);

        TextField textField = new TextField();
        textField.setPromptText("Ingrese Su Nombre");
        textField.setTranslateX(10);
        textField.setTranslateY(-450);
        textField.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        textField.setMaxWidth(400);


        EnterEscenaBienvenidaEventHandler ingresarNombre = new EnterEscenaBienvenidaEventHandler(leftSide, textField, juego, rightSide, stage);
        textField.setOnKeyPressed(ingresarNombre);

        BackgroundFill fondoGris = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background fondo = new Background(fondoGris);
        textField.setBackground(fondo);

        leftSide.getChildren().addAll(lugar, tiempoRestante, mensajeBienvenida, textField);
        return leftSide;
    }

    private VBox crearRightSide(VBox rightSide) {

        rightSide.setSpacing(10);
        rightSide.setMaxWidth(420);
        rightSide.setMaxHeight(600);

        Label ingresarNombre = new Label("Ingrese Su Nombre");
        ingresarNombre.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));
        ingresarNombre.setTranslateX(65);
        ingresarNombre.setTranslateY(-70);

        rightSide.getChildren().addAll(ingresarNombre);
        return rightSide;
    }
}