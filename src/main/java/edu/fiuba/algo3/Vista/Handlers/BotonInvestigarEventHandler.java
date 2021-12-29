package edu.fiuba.algo3.Vista.Handlers;

//import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.Vista.LayoutInvestigar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonInvestigarEventHandler implements EventHandler<ActionEvent> {

    VBox rightSide;
    Jugador jugador;
    Stage stage;
    public BotonInvestigarEventHandler(Jugador jugador, Stage stage, VBox rightSide){
        this.rightSide = rightSide;
        this.jugador = jugador;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
/*
        LayoutInvestigar layoutInvestigar = crearLayoutInvestigar();
        EscenaPrincipal escenaPrincipal = new EscenaPrincipal(stage, jugador, layoutInvestigar);
        Scene escenaActulizada = new Scene(escenaPrincipal);
        stage.setScene(escenaActulizada);
        stage.setFullScreen(true);*/
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        rightSide.getChildren().remove(2);
        rightSide.getChildren().remove(2);
        LayoutInvestigar layoutInvestigar = crearLayoutInvestigar();



    }

    private LayoutInvestigar crearLayoutInvestigar(){

        LayoutInvestigar layoutInvestigar = new LayoutInvestigar(jugador, rightSide, stage);

        return layoutInvestigar;
    }
}