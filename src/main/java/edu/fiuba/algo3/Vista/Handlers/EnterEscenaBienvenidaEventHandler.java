package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaAsignarCaso;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class EnterEscenaBienvenidaEventHandler implements EventHandler<KeyEvent> {

    private VBox leftSide;
    private TextField textField;
    private VBox rightSide;
    private Juego juego;
    private Integer cantidadEnters;
    private Stage stage;
    private Jugador jugador;

    public EnterEscenaBienvenidaEventHandler(VBox leftSide, TextField textField, Juego juego, VBox rightSide, Stage stage){

        this.leftSide = leftSide;
        this.textField = textField;
        this.rightSide = rightSide;
        this.cantidadEnters = 0;
        this.juego = juego;
        this.stage = stage;
    }

    public void handle(KeyEvent keyEvent){

        if((keyEvent.getCode().equals(KeyCode.ENTER)) && cantidadEnters == 1){
            String musicFile = "src/main/resources/sonidos/SonidoBoton.mp3";    // For example

            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

            try {
                juego.comenzarCaso();
            } catch (Exception e) {
                e.printStackTrace();
            }
            EscenaAsignarCaso asignarCaso = new EscenaAsignarCaso(stage, jugador);
            Scene escenaAsignarCaso = new Scene(asignarCaso, 960, 600);
            stage.setScene(escenaAsignarCaso);
            EnterEscenaAsignarCasoEventHandler siguiente = new EnterEscenaAsignarCasoEventHandler(this.stage, jugador);
            escenaAsignarCaso.setOnKeyPressed(siguiente);

        }

        if((keyEvent.getCode().equals(KeyCode.ENTER)) && cantidadEnters == 0){
            String musicFile = "src/main/resources/sonidos/SonidoBoton.mp3";     // For example

            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

            jugador = juego.IdentificarJugador(textField.getText());

            Text texto = new Text(textField.getText() + ", su rango es " + jugador.rango() + ". Para subir de rango deberá arrestar ladrones ¡pero cuidado! la dificultad de los casos aumentará a medida que lo haga su rango.\n\n A continuación se le asignará un caso. Suerte y mucho cuidado!");
            texto.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
            texto.setTranslateX(15);
            texto.setTranslateY(-450);
            textField.setEditable(false);
            texto.setWrappingWidth(400);

            leftSide.getChildren().add(texto);
            rightSide.getChildren().remove(2);

            Label presioneEnter = new Label("Presione 'Enter'");
            presioneEnter.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 25));
            presioneEnter.setTranslateX(90);
            presioneEnter.setTranslateY(-70);

            rightSide.getChildren().add(presioneEnter);
            cantidadEnters++;
        }



    }
}