package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonEntrarEventHandler;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class IdentificarJugador extends VBox {

    Stage stage;
    Juego juego;

    public IdentificarJugador(Stage stage, Juego juego) throws Exception {

        /*super();
        this.stage = stage;
        this.juego = juego;



        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        Label texto = new Label();
        texto.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        texto.setText("Bienvenio detective! Identifiquese");

        TextField textField = new TextField();
        textField.setPromptText("Ingrese Su Nombre");


        EscenaPrincipal escenaPrincipal = crearEscenaPrincipal(textField.getText());
        Scene proximaEscena = new Scene(escenaPrincipal);


        Button botonAceptar = new Button();
        botonAceptar.setText("Aceptar");
        BotonEntrarEventHandler botonEntrarEventHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonAceptar.setOnAction(botonEntrarEventHandler);


        this.getChildren().addAll(texto, textField, botonAceptar);*/

    }
/*
    private EscenaPrincipal crearEscenaPrincipal(String nombre) throws Exception {
        Jugador jugador = juego.IdentificarJugador(nombre);
        juego.crearCaso();
        TextArea centro = crearCenter(jugador);

        EscenaPrincipal escenaPrincipal = new EscenaPrincipal(stage, jugador, centro);

        return escenaPrincipal;
    }

    private TextArea crearCenter(Jugador jugador){

        TextArea textArea = new TextArea();
        //textArea.setMaxSize(600, 600);

        String descripcion;
        descripcion = jugador.getDescripcionCaso();

        textArea.setText(descripcion);
        return textArea;
    }*/
}
