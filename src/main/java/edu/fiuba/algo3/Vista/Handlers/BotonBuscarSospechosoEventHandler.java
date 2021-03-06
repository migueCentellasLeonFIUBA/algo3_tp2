package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaTiempoTerminado;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ladron.ISospechable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BotonBuscarSospechosoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    VBox leftSide;
    Stage stage;

    public BotonBuscarSospechosoEventHandler(Jugador jugador, VBox leftSide, Stage stage){
        this.jugador = jugador;
        this.leftSide = leftSide;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){

        String musicFile = "src/main/resources/sonidos/SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        ArrayList<ISospechable> listaSospechosos = jugador.buscarSospechosos();
        //ArrayList<String> sospechosos = new ArrayList<>();

        if(jugador.terminarJuego()){
            EscenaTiempoTerminado tiempoTerminado = null;
            try {
                tiempoTerminado = new EscenaTiempoTerminado(stage, jugador);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene escenaTiempoTerminado = new Scene(tiempoTerminado, 960, 600);
            stage.setScene(escenaTiempoTerminado);

            String filePerder = "src/main/resources/sonidos/SonidoBoton.mp3";     // For example

            Media mediaPerder = new Media(new File(filePerder).toURI().toString());
            MediaPlayer mediaPlayerPerder = new MediaPlayer(mediaPerder);
            mediaPlayerPerder.play();
        }


        String sospechosos = "";
        String texto = "";



        for (ISospechable sospechoso: listaSospechosos) {
            sospechosos = sospechosos + sospechoso.getNombre() + ", ";
        }

        if(sospechosos.length() != 0){
            texto = sospechosos.substring(0, sospechosos.length() - 2);
        }

        if(sospechosos.length() == 0){
            texto = "No hay coincidencias";
        }

        texto = texto + "\n\n" + jugador.orden();


        Text text = new Text(texto);
        text.setTranslateX(20);
        text.setTranslateY(-450);
        text.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));
        text.setFill(Color.BLACK);
        text.setWrappingWidth(400);

        Label tiempoRestante = new Label(jugador.diaYHora());
        tiempoRestante.setTranslateX(115);
        tiempoRestante.setTranslateY(-505);
        tiempoRestante.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));

        leftSide.getChildren().remove(3);
        leftSide.getChildren().add(3, tiempoRestante);

        leftSide.getChildren().remove(5);
        leftSide.getChildren().add(text);
    }
}