package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonComputadoraEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonInvestigarEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonViajarEventHandler;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class EscenaPrincipal extends BorderPane {

    Jugador jugador;
    Stage stage;

    public EscenaPrincipal(Stage stage, Jugador jugador, Node centro){
        this.stage = stage;
        this.jugador = jugador;
        this.setTop(crearTop());
        this.setLeft(crearLeft());
        //this.setCenter(crearCenter());
        this.setCenter(centro);
    }

    private HBox crearTop(){
        HBox top = new HBox();

        top.setSpacing(50);
        top.setAlignment(Pos.CENTER);

        Label tiempoRestante = new Label();
        tiempoRestante.setText(String.valueOf((jugador.horasRestantes())));
        tiempoRestante.setMaxSize(300, 300);

        Label ciudadActual = new Label();
        ciudadActual.setText(jugador.ciudadActual());
        ciudadActual.setMaxSize(300, 300);

        top.getChildren().addAll(tiempoRestante, ciudadActual);
        return top;
    }

    private VBox crearLeft(){

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(0);
        //vbox.setMaxWidth(3000);

        Button botonComputadora = new Button();
        botonComputadora.setText("Computadora");
        //botonComputadora.setMaxSize(1000, 1000);
        BotonComputadoraEventHandler botonComputadoraEventHandler = new BotonComputadoraEventHandler(this, jugador, stage);
        botonComputadora.setOnAction(botonComputadoraEventHandler);

        Button botonViajar = new Button();
        botonViajar.setText("Viajar");
        //botonAeropuerto.setMaxSize(1000, 1000);
        BotonViajarEventHandler botonViajarEventHandler = new BotonViajarEventHandler(this, jugador, stage);
        botonViajar.setOnAction(botonViajarEventHandler);

        Button botonInvestigar = new Button();
        botonInvestigar.setText("Investigar");
        //botonInvestigar.setMaxWidth(10000);
        BotonInvestigarEventHandler botonInvestigarEventHandler = new BotonInvestigarEventHandler(this, jugador, stage);
        botonInvestigar.setOnAction(botonInvestigarEventHandler);

        vbox.getChildren().addAll(botonComputadora, botonViajar, botonInvestigar);
        return vbox;
    }

/*
    private TextArea crearCenter(){

        TextArea textArea = new TextArea();
        //textArea.setMaxSize(600, 600);

        String descripcion;
        descripcion = jugador.getDescripcionCaso();

        textArea.setText(descripcion);
        return textArea;
    }*/
}
