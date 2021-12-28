package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.LayoutDerechoComputadora;
import edu.fiuba.algo3.Vista.LayoutIzquierdoComputadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.FileNotFoundException;



public class BotonComputadoraEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    VBox leftSide;
    VBox rightSide;
    Jugador jugador;

    public BotonComputadoraEventHandler(VBox leftSide, VBox rightSide, Stage stage, Jugador jugador){
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.jugador = jugador;
        this.stage = stage;

        String musicFile = "StayTheNight.mp3";     // For example

        File mediaFile = new File("assets/media/Golden-48569.mp4");
        Media media = new Media(mediaFile.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();
    }

    public void handle(ActionEvent actionEvent){

        leftSide.getChildren().remove(4);
        //leftSide.getChildren().remove((3));
        LayoutIzquierdoComputadora layoutIzquierdoComputadora = new LayoutIzquierdoComputadora(jugador, leftSide);

        //leftSide.getChildren().add(layoutIzquierdoComputadora);


        LayoutDerechoComputadora layoutDerechoComputadora = null;
        try {
            layoutDerechoComputadora = crearLayoutComputadora();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        rightSide.getChildren().remove(2);
        rightSide.getChildren().remove(2);
        rightSide.getChildren().addAll(layoutDerechoComputadora);
    }

    private LayoutDerechoComputadora crearLayoutComputadora() throws FileNotFoundException {

        LayoutDerechoComputadora layoutDerechoComputadora = new LayoutDerechoComputadora(jugador, stage, leftSide);

        return layoutDerechoComputadora;
    }
}
