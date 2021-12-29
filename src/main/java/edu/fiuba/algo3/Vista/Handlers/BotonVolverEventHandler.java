package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class BotonVolverEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Jugador jugador;

    public BotonVolverEventHandler(Stage stage, Jugador jugador){

        this.jugador = jugador;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        EscenaPrincipal escenaPrincipal = null;

        try {
            escenaPrincipal = new EscenaPrincipal(stage, jugador);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(escenaPrincipal, 960, 600);
        stage.setScene(scene);

    }

}