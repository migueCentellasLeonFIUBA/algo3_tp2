package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaAsignarCaso;
import edu.fiuba.algo3.modelo.IBuilder.ConstructorJuegoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorJuego;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonVolverAJugarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Jugador jugador;

    public BotonVolverAJugarEventHandler(Stage stage, Jugador jugador){
        this.stage = stage;
        this.jugador = jugador;
    }

    public void handle(ActionEvent actionEvent){
        String musicFile = "C:\\Users\\fabia\\OneDrive\\Documentos\\tp2\\sonidos\\SonidoBoton.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();



        Juego juego = null;
        try {
            juego = crearModelo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String nombre = jugador.nombre();
        jugador = juego.IdentificarJugador(nombre);

        try {
            juego.comenzarCaso();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EscenaAsignarCaso asignarCaso = new EscenaAsignarCaso(stage, jugador);
        Scene escenaAsignarCaso = new Scene(asignarCaso, 960, 600);
        stage.setScene(escenaAsignarCaso);
        EnterEscenaAsignarCasoEventHandler siguiente = new EnterEscenaAsignarCasoEventHandler(this.stage, jugador);
        escenaAsignarCaso.setOnKeyPressed(siguiente);


    }

    private Juego crearModelo() throws Exception {
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);

        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);


        return director.obtenerJuego();
    }
}
