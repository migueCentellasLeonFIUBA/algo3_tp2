package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;

public class BotonVisitarEdificioEventHandler implements EventHandler<ActionEvent> {

    Edificio edificio;
    Jugador jugador;
    VBox rightSide;
    Text pista;

    public BotonVisitarEdificioEventHandler(Edificio edificio, Jugador jugador, VBox rightSide, Text pista){
        this.edificio = edificio;
        this.jugador = jugador;
        this.rightSide = rightSide;
        this.pista = pista;
    }

    public void handle(ActionEvent actionEvent) {
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        pista.setText(jugador.visitarEdificio(edificio));
        /*Text pista = new Text(jugador.visitarEdificio(edificio));
        pista.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
        pista.setWrappingWidth(400);

        pista.setTranslateY(-400);
        pista.setTranslateX(20);*/


    }
}