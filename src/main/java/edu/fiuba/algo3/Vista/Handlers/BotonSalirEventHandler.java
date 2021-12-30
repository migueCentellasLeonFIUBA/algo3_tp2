package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonSalirEventHandler(Stage stage){
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();


        stage.close();
    }
}
