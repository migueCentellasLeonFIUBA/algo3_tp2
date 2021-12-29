package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EscenaPrincipal extends HBox {

    private Stage stage;
    private Jugador jugador;
    private VBox leftSide;
    private VBox rightSide;

    public EscenaPrincipal(Stage stage, Jugador jugador) throws FileNotFoundException {

        this.jugador = jugador;
        this.stage = stage;

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

    private VBox crearLeftSide(VBox leftSide) throws FileNotFoundException {

        leftSide.setSpacing(10);
        leftSide.setMaxWidth(420);
        leftSide.setMaxHeight(600);

        Label lugar = new Label(jugador.obtenerNombreCiudad().toUpperCase());
        lugar.setTranslateX(135);
        lugar.setTranslateY(-505);
        lugar.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));

        Label tiempoRestante = new Label(jugador.diaYHora());
        tiempoRestante.setTranslateX(115);
        tiempoRestante.setTranslateY(-505);
        tiempoRestante.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));
        //tiempoRestante.setPrefWidth(300);



        InputStream stream = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\IndianapolisImage.jpg");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        imageView.setTranslateX(20);
        imageView.setTranslateY(-475);
        imageView.setFitWidth(400);
        imageView.setFitHeight(380);
        //imageView.setEffect(new GaussianBlur(2));


        leftSide.getChildren().addAll(lugar, tiempoRestante, imageView);
        return  leftSide;
    }

    public VBox crearRightSide(VBox rightSide) throws FileNotFoundException {

        rightSide.setSpacing(10);
        rightSide.setMaxWidth(420);
        rightSide.setMaxHeight(600);

        Text descripcion = new Text(jugador.getDescripcionCiudad());
        descripcion.setTranslateX(20);
        descripcion.setTranslateY(-500);
        descripcion.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        descripcion.setFill(Color.BLACK);
        descripcion.setWrappingWidth(400);


        HBox botones = new HBox();

        BackgroundFill fondoGris = new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background fondo = new Background(fondoGris);

        FileInputStream inputComputadora = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\ImagenComputadora.jpg");
        Image imagenComputadora = new Image(inputComputadora);
        ImageView imageViewComputadora = new ImageView(imagenComputadora);
        imageViewComputadora.setFitHeight(80);
        imageViewComputadora.setFitWidth(120);
        Button computadora = new Button("", imageViewComputadora);
        computadora.setTranslateY(-450);
        computadora.setTranslateX(45);
        computadora.setBackground(fondo);
        computadora.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerComputadora = new MouseHoverEnterEventHandler(computadora);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerComputadora = new MouseHoverExitEventHandler(computadora);
        computadora.setOnMouseEntered(mouseHoverEventHandlerComputadora);
        computadora.setOnMouseExited(mouseHoverExitEventHandlerComputadora);

        BotonComputadoraEventHandler botonComputadoraEventHandler = new BotonComputadoraEventHandler(leftSide, rightSide, stage, jugador);
        computadora.setOnAction(botonComputadoraEventHandler);

        FileInputStream inputEdificio = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\ImagenEdificio.jpg");
        Image imagenEdificio = new Image(inputEdificio);
        ImageView imageViewEdificio = new ImageView(imagenEdificio);
        imageViewEdificio.setFitHeight(80);
        imageViewEdificio.setFitWidth(100);
        Button edificio = new Button("", imageViewEdificio);
        edificio.setTranslateY(-450);
        edificio.setTranslateX(40);
        edificio.setBackground(fondo);
        edificio.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerEdificio = new MouseHoverEnterEventHandler(edificio);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerEdificio = new MouseHoverExitEventHandler(edificio);
        edificio.setOnMouseEntered(mouseHoverEventHandlerEdificio);
        edificio.setOnMouseExited(mouseHoverExitEventHandlerEdificio);

        BotonInvestigarEventHandler botonInvestigarEventHandler = new BotonInvestigarEventHandler(jugador, stage, rightSide);
        edificio.setOnAction(botonInvestigarEventHandler);

        FileInputStream inputAeropuerto = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\ImagenAeropuerto.jpg");
        Image imagenAeropuerto = new Image(inputAeropuerto);
        ImageView imageViewAeropuerto = new ImageView(imagenAeropuerto);
        imageViewAeropuerto.setFitHeight(80);
        imageViewAeropuerto.setFitWidth(100);
        Button aeropuerto = new Button("", imageViewAeropuerto);
        aeropuerto.setTranslateY(-450);
        aeropuerto.setTranslateX(35);
        aeropuerto.setBackground(fondo);
        //aeropuerto.setEffect(new Glow());
        aeropuerto.setEffect(new InnerShadow());

        MouseHoverEnterEventHandler mouseHoverEventHandlerAeropuerto = new MouseHoverEnterEventHandler(aeropuerto);
        MouseHoverExitEventHandler mouseHoverExitEventHandlerAeropuerto = new MouseHoverExitEventHandler(aeropuerto);
        aeropuerto.setOnMouseEntered(mouseHoverEventHandlerAeropuerto);
        aeropuerto.setOnMouseExited(mouseHoverExitEventHandlerAeropuerto);

        BotonViajarEventHandler botonViajarEventHandler = new BotonViajarEventHandler(rightSide, jugador, stage);
        aeropuerto.setOnAction(botonViajarEventHandler);

        botones.getChildren().addAll(aeropuerto, edificio, computadora);
        rightSide.getChildren().addAll(descripcion, botones);
        return rightSide;
    }

}