package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class BotonViajarADestinoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    HBox hbox;
    Stage stage;
    Ciudad destino;

    public BotonViajarADestinoEventHandler(Jugador jugador, Stage stage, Ciudad destino){
        this.jugador = jugador;
        this.hbox = hbox;
        this.stage = stage;
        this.destino = destino;
    }

    public void handle(ActionEvent actionEvent){
        jugador.viajarACiudad(destino);
        TextArea center = crearCenter();
        //BorderPane newBorderPane = new BorderPane(layoutComputadora, borderPane.getTop(), borderPane.getRight(), borderPane.getBottom(), borderPane.getLeft());
        EscenaPrincipal escenaPrincipal = null;
        try {
            escenaPrincipal = new EscenaPrincipal(stage, jugador);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scene escenaActulizada = new Scene(escenaPrincipal, 960, 600);
        stage.setScene(escenaActulizada);
        String sonidoBoton = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example
        String sonidoAvion = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoAvion.mp3";     // For example


        Media boton = new Media(new File(sonidoBoton).toURI().toString());
        MediaPlayer mediaPlayerBoton = new MediaPlayer(boton);
        mediaPlayerBoton.play();

        Media avion = new Media(new File(sonidoAvion).toURI().toString());
        MediaPlayer mediaPlayerAvion = new MediaPlayer(avion);
        mediaPlayerAvion.play();


    }

    private TextArea crearCenter(){

        TextArea textArea = new TextArea();
        //textArea.setMaxSize(600, 600);

        String descripcion;
        descripcion = jugador.getDescripcionCiudad();

        textArea.setText(descripcion);
        return textArea;
    }
}