package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonVisitarEdificioEventHandler;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LayoutInvestigar extends VBox {

    Jugador jugador;

    public LayoutInvestigar(Jugador jugador){

        this.jugador = jugador;

        Label pista = new Label();
        HBox botones = crearBotones(pista);

        this.getChildren().addAll(botones, pista);


    }

    private HBox crearBotones(Label pista){

        HBox hbox = new HBox();


        Button aeropuerto = new Button("Aeropuerto");
        BotonVisitarEdificioEventHandler botonAeropuertoHandler = new BotonVisitarEdificioEventHandler(new AeroPuerto(), jugador, pista);
        aeropuerto.setOnAction(botonAeropuertoHandler);

        Button banco = new Button("Banco");
        BotonVisitarEdificioEventHandler botonBancoHandler = new BotonVisitarEdificioEventHandler(new Banco(), jugador, pista);
        banco.setOnAction(botonBancoHandler);

        Button biblioteca = new Button("Biblioteca");
        BotonVisitarEdificioEventHandler botonBibliotecaHandler = new BotonVisitarEdificioEventHandler(new Biblioteca(), jugador, pista);
        biblioteca.setOnAction(botonBibliotecaHandler);

        Button bolsa = new Button("Bolsa");
        BotonVisitarEdificioEventHandler botonBolsaHandler = new BotonVisitarEdificioEventHandler(new Bolsa(), jugador, pista);
        bolsa.setOnAction(botonBolsaHandler);

        Button puerto = new Button("Puerto");
        BotonVisitarEdificioEventHandler botonPuertoHandler = new BotonVisitarEdificioEventHandler(new Puerto(), jugador, pista);
        puerto.setOnAction(botonPuertoHandler);



        hbox.getChildren().addAll(aeropuerto, bolsa, biblioteca, puerto, banco);
        return hbox;
    }
}
