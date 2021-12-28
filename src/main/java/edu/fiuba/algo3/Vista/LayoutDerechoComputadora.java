package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LayoutDerechoComputadora extends VBox {

    Jugador jugador;
    Stage stage;

    public LayoutDerechoComputadora(Jugador jugador, Stage stage, VBox leftSide) throws FileNotFoundException {

        this.jugador = jugador;
        this.stage = stage;

        Label computadora = new Label("COMPUTADORA INTERPOL");
        computadora.setTranslateY(-480);
        computadora.setTranslateX(80);
        computadora.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        computadora.setTextFill(Color.BLACK);


        Label labelSexo = crearLabel();
        BotonSiguienteSexoEventHandler botonSiguienteSexoEventHandler = new BotonSiguienteSexoEventHandler(jugador, labelSexo);
        HBox sexo = crearCaja(botonSiguienteSexoEventHandler, labelSexo);

        Label labelCabello = crearLabel();
        BotonSiguienteCabelloEventHandler botonSiguienteCabelloEventHandler = new BotonSiguienteCabelloEventHandler(jugador, labelCabello);
        HBox cabello = crearCaja(botonSiguienteCabelloEventHandler, labelCabello);

        Label labelHobby = crearLabel();
        BotonSiguienteHobbyEventHandler botonSiguienteHobbyEventHandler = new BotonSiguienteHobbyEventHandler(jugador, labelHobby);
        HBox hobby = crearCaja(botonSiguienteHobbyEventHandler, labelHobby);

        Label labelSenia = crearLabel();
        BotonSiguienteSeniaEventHandler botonSiguienteSeniaEventHandler = new BotonSiguienteSeniaEventHandler(jugador, labelSenia);
        HBox senia = crearCaja(botonSiguienteSeniaEventHandler, labelSenia);

        Label labelVehiculo = crearLabel();
        BotonSiguienteVehiculoEventHandler botonSiguienteVehiculoEventHandler = new BotonSiguienteVehiculoEventHandler(jugador, labelVehiculo);
        HBox vehiculo = crearCaja(botonSiguienteVehiculoEventHandler, labelVehiculo);

        BackgroundFill fondoGrisClaro = new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisClaro = new Background(fondoGrisClaro);

        Button buscarSospechoso = new Button();
        buscarSospechoso.setAlignment(Pos.BOTTOM_RIGHT);
        buscarSospechoso.setText("Buscar Sospechoso");
        buscarSospechoso.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        buscarSospechoso.setTranslateY(-430);
        buscarSospechoso.setBackground(grisClaro);
        BotonBuscarSospechosoEventHandler botonBuscarSospechosoEventHandler = new BotonBuscarSospechosoEventHandler(jugador, leftSide);
        buscarSospechoso.setOnAction(botonBuscarSospechosoEventHandler);

        BackgroundFill fondoGrisOscuro = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background grisOscuro = new Background(fondoGrisOscuro);


        Button volver = new Button("Volver");
        volver.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 35));
        volver.setTranslateY(-390);
        volver.setTranslateX(120);
        volver.setBackground(grisOscuro);
        BotonVolverEventHandler botonVolverEventHandler = new BotonVolverEventHandler(stage, jugador);
        volver.setOnAction(botonVolverEventHandler);

        MouseHoverEnterEventHandler mouseHoverEventHandlerVolver = new MouseHoverEnterEventHandler(volver);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerVolver = new MouseHoverExitEventHandler(volver);
        volver.setOnMouseEntered(mouseHoverEventHandlerVolver);
        volver.setOnMouseExited(mouseHoverExitEventHandlerVolver);

        this.getChildren().addAll(computadora, sexo, cabello, hobby, senia, vehiculo, buscarSospechoso, volver);


    }

    private HBox crearCaja(EventHandler eventHandler, Label label) throws FileNotFoundException {

        HBox hbox = new HBox();

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        BackgroundFill fondoGris = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background fondo = new Background(fondoGris);

        FileInputStream inputSexo = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\ImagenFlechaDerecha.png");
        Image imagenSexo = new Image(inputSexo);
        ImageView imageViewSexo = new ImageView(imagenSexo);
        imageViewSexo.setFitHeight(40);
        imageViewSexo.setFitWidth(50);

        Button siguienteSexo = new Button("", imageViewSexo);
        siguienteSexo.setBackground(fondo);
        siguienteSexo.setTranslateY(-450);
        siguienteSexo.setTranslateX(20);
        siguienteSexo.setOnAction(eventHandler);

        hbox.getChildren().addAll(label, siguienteSexo);
        return hbox;
    }

    private Label crearLabel(){
        Label label = new Label();
        label.setText("Sin Asignar");
        label.setTranslateY(-450);
        label.setTranslateX(20);
        label.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        label.setTextFill(Color.BLACK);

        return label;
    }




}
