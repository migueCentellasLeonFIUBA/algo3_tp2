package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaAtraparLadron;
import edu.fiuba.algo3.Vista.EscenaTiempoTerminado;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class BotonVisitarEdificioEventHandler implements EventHandler<ActionEvent> {

    Edificio edificio;
    Jugador jugador;
    VBox leftSide;
    Text pista;
    Stage stage;

    public BotonVisitarEdificioEventHandler(Edificio edificio, Jugador jugador, VBox leftSide, Text pista, Stage stage) {
        this.edificio = edificio;
        this.jugador = jugador;
        this.leftSide = leftSide;
        this.pista = pista;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent) {
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        /*if(jugador.terminarJuego()){
            EscenaTiempoTerminado tiempoTerminado = null;
            try {
                tiempoTerminado = new EscenaTiempoTerminado(stage, jugador);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene escenaTiempoTerminado = new Scene(tiempoTerminado, 960, 600);
            stage.setScene(escenaTiempoTerminado);
        }*/

        /*else {
            String pistaEdificio = jugador.visitarEdificio(edificio);

            if(pistaEdificio.contains("Ladron atrapado")){
                EscenaAtraparLadron atraparLadron = null;
                try {
                    atraparLadron = new EscenaAtraparLadron(stage, pistaEdificio, jugador);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Scene escenaAtraparLadron = new Scene(atraparLadron, 960, 600);
                stage.setScene(escenaAtraparLadron);

                if(pistaEdificio.contains("correcta")){
                    String musicFileGanar = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoGanar.mp3";     // For example

                    Media sonidoGanar = new Media(new File(musicFileGanar).toURI().toString());
                    MediaPlayer mediaPlayerGanar = new MediaPlayer(sonidoGanar);
                    mediaPlayerGanar.play();
                }
            }*/
        String pistaEdificio = jugador.visitarEdificio(edificio);

        if (jugador.terminarJuego()) {
            EscenaTiempoTerminado tiempoTerminado = null;
            try {
                tiempoTerminado = new EscenaTiempoTerminado(stage, jugador);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene escenaTiempoTerminado = new Scene(tiempoTerminado, 960, 600);
            stage.setScene(escenaTiempoTerminado);

            String filePerder = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoPerder.mp3";     // For example

            Media mediaPerder = new Media(new File(filePerder).toURI().toString());
            MediaPlayer mediaPlayerPerder = new MediaPlayer(mediaPerder);
            mediaPlayerPerder.play();

        }
        else {
            if (pistaEdificio.contains("Ladron atrapado")) {
                EscenaAtraparLadron atraparLadron = null;
                try {
                    atraparLadron = new EscenaAtraparLadron(stage, pistaEdificio, jugador);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Scene escenaAtraparLadron = new Scene(atraparLadron, 960, 600);
                stage.setScene(escenaAtraparLadron);

                if (pistaEdificio.contains("correcta")) {
                    String musicFileGanar = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoGanar.mp3";     // For example

                    Media sonidoGanar = new Media(new File(musicFileGanar).toURI().toString());
                    MediaPlayer mediaPlayerGanar = new MediaPlayer(sonidoGanar);
                    mediaPlayerGanar.play();
                }

            }
            pista.setText(pistaEdificio);
            Label tiempoRestante = new Label(jugador.diaYHora());
            tiempoRestante.setTranslateX(115);
            tiempoRestante.setTranslateY(-505);
            tiempoRestante.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 20));

            leftSide.getChildren().remove(3);
            leftSide.getChildren().add(3, tiempoRestante);


            }
        }
}
