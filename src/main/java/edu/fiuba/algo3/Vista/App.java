package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);*/
        Juego juego = crearModelo();

        IdentificarJugador identificarJugador = new IdentificarJugador(stage, juego);
        Scene escenaIdentificarJugador = new Scene(identificarJugador);

        PantallaDeInicio pantallaDeInicio = new PantallaDeInicio(stage, escenaIdentificarJugador);
        Scene escenaPantallaDeInicio = new Scene(pantallaDeInicio);

        stage.setScene(escenaPantallaDeInicio);
        stage.setTitle("Carmen Sandiego");


        //PantallaDeCarga pantallaDeCarga = new PantallaDeCarga(stage);
        //Scene escenaJuego = new Scene(pantallaDeCarga, 640, 480);



        stage.setFullScreen(true);

        stage.show();


    }

    private Juego crearModelo() throws Exception {
        return new Juego();
    }



    public static void main(String[] args) {
        launch();
    }

}