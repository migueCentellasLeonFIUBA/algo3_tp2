package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonSiguienteSexoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    Label label;
    public BotonSiguienteSexoEventHandler(Jugador jugador, Label label){
        this.jugador = jugador;
        this.label = label;
    }

    public void handle(ActionEvent actionEvent){
        String musicFile = "src/main/resources/sonidos/SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        jugador.siguienteSexo();
        label.setText(jugador.getSexoComputadora());

    }
}