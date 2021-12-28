package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Juego juego = crearModelo();

        //IdentificarJugador identificarJugador = new IdentificarJugador(stage, juego);
        //Scene escenaIdentificarJugador = new Scene(identificarJugador);

        //EscenaPrincipal identificarJugador = new EscenaPrincipal(stage, jugador , crearLeftSide(), crearRightSide());

        EscenaBienvenida bienvenida = new EscenaBienvenida(stage, juego);
        Scene escenaBienvenida = new Scene(bienvenida, 960, 600);

        PantallaDeInicio pantallaDeInicio = new PantallaDeInicio(stage, escenaBienvenida);
        Scene escenaPantallaDeInicio = new Scene(pantallaDeInicio, 960, 600);


        stage.setResizable(false);

        escenaPantallaDeInicio.setOnKeyPressed((KeyEvent event) -> {
            stage.setScene(escenaBienvenida);

        });

        stage.setScene(escenaPantallaDeInicio);
        stage.setTitle("Carmen Sandiego");
        stage.show();
    }

    private Juego crearModelo() throws Exception {
        return new Juego();
    }


    public static void main(String[] args) {
        launch();
    }

}