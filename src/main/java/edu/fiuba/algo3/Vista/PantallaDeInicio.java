package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.FontPosture;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PantallaDeInicio extends VBox {

    Stage stage;

    public PantallaDeInicio(Stage stage, Scene proximaEscena) throws FileNotFoundException {

        super();



        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\MusicaInicialDos.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.isAutoPlay(true);
        //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        //mediaPlayer.setAutoPlay(true);
        //mediaPlayer.play();



        this.stage = stage;
        //this.stage.setMaxHeight(600);
        //this.stage.setMaxWidth(960);
        //this.stage.setMaximized(true);
        this.setAlignment(Pos.TOP_CENTER);

        this.setSpacing(20);
        this.setPadding(new Insets(25));

        InputStream stream = new FileInputStream("C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\images\\pantallaCarga.png");
        //Image imagen = new Image("https://www.mobygames.com/images/shots/l/491-where-in-the-world-is-carmen-sandiego-dos-screenshot-title-screen.gif");
        Image imagen = new Image(stream);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        this.setBackground(new Background(imagenDeFondo));

        GaussianBlur blur = new GaussianBlur();
        blur.setRadius(2.5);

        Label nombre = new Label();
        nombre.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 30));
        nombre.setText("Carmen Sandiego");
        nombre.setTextFill(Color.DARKGRAY);
        nombre.setEffect(blur);

        Label presioneCualquierTecla = new Label();
        presioneCualquierTecla.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 17));
        presioneCualquierTecla.setText("Presione Cualquier Tecla Para Continuar");
        presioneCualquierTecla.setTextFill(Color.DARKGRAY);
        presioneCualquierTecla.setEffect(blur);

        this.getChildren().addAll(nombre, presioneCualquierTecla);

    }

}