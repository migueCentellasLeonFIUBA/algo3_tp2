package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonViajarADestinoEventHandler;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ciudades.Mapa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class LayoutViajar extends VBox {

    Jugador jugador;
    Mapa mapa;
    BorderPane borderPane;
    Stage stage;

    public LayoutViajar(Jugador jugador, BorderPane borderPane, Stage stage){

        this.jugador = jugador;
        this.borderPane = borderPane;
        this.stage = stage;

        HBox hbox = crearBotones();

        this.getChildren().addAll(hbox);

    }

    private HBox crearBotones(){

        //ArrayList<Ciudad> posiblesDestinos = jugador.obtenerSiguientesDestinos();
        ArrayList<Ciudad> posiblesDestinos = mapa.getCiudadesDisponibles();
        HBox botones = new HBox();

        Button destinoUno = new Button((posiblesDestinos.get(0).getNombre()));
        BotonViajarADestinoEventHandler botonViajarADestinoUnoEventHandler = new BotonViajarADestinoEventHandler(jugador, borderPane, stage, posiblesDestinos.get(0));
        destinoUno.setOnAction(botonViajarADestinoUnoEventHandler);

        Button destinoDos = new Button((posiblesDestinos.get(1).getNombre()));
        BotonViajarADestinoEventHandler botonViajarADestinoDosEventHandler = new BotonViajarADestinoEventHandler(jugador, borderPane, stage, posiblesDestinos.get(1));
        destinoDos.setOnAction(botonViajarADestinoDosEventHandler);

        Button destinoTres = new Button((posiblesDestinos.get(2).getNombre()));
        BotonViajarADestinoEventHandler botonViajarADestinoTresEventHandler = new BotonViajarADestinoEventHandler(jugador, borderPane, stage, posiblesDestinos.get(2));
        destinoTres.setOnAction(botonViajarADestinoTresEventHandler);

        botones.getChildren().addAll(destinoUno, destinoDos, destinoTres);

        return botones;
    }


}
