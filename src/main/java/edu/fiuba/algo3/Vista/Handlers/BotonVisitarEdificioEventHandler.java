package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;

public class BotonVisitarEdificioEventHandler implements EventHandler<ActionEvent> {

    Edificio edificio;
    Jugador jugador;
    VBox rightSide;

    public BotonVisitarEdificioEventHandler(Edificio edificio, Jugador jugador, VBox rightSide){
        this.edificio = edificio;
        this.jugador = jugador;
        this.rightSide = rightSide;
    }

    public void handle(ActionEvent actionEvent) {
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        String pista = null;
        try {
            pista = jugador.visitarEdificio(edificio);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
