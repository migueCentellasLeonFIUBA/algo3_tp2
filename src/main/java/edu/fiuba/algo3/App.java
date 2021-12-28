package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.EscenaBienvenida;
import edu.fiuba.algo3.Vista.PantallaDeInicio;
import edu.fiuba.algo3.modelo.IBuilder.ConstructorJuegoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorJuego;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
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

   /* @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }*/

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
        Parser parser = new Parser();
        Fachada fachada = new Fachada(parser);

        ConstructorJuegoConcreto constructor = new ConstructorJuegoConcreto();
        DirectorJuego director = new DirectorJuego(constructor);
        director.crearJuego(fachada);


        return director.obtenerJuego();
    }


    public static void main(String[] args) {
        launch();
    }

}

