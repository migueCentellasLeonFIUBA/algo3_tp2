package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Juego juego = crearModelo();

        IdentificarJugador identificarJugador = new IdentificarJugador(stage, juego);
        Scene escenaIdentificarJugador = new Scene(identificarJugador);

        PantallaDeInicio pantallaDeInicio = new PantallaDeInicio(stage, escenaIdentificarJugador);
        Scene escenaPantallaDeInicio = new Scene(pantallaDeInicio);


        escenaPantallaDeInicio.setOnKeyPressed((KeyEvent event) -> {
            stage.setScene(escenaIdentificarJugador);
        });

        stage.setScene(escenaPantallaDeInicio);
        stage.setTitle("Carmen Sandiego");


        stage.setMaxHeight(600);
        stage.setMaxWidth(960);
        stage.setMaximized(true);


        stage.show();


    }

    private Juego crearModelo() throws Exception {
        return new Juego();
    }



    public static void main(String[] args) {
        launch();
    }

}