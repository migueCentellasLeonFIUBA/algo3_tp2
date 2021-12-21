package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Vista.Handlers.BotonBuscarSospechosoEventHandler;
import edu.fiuba.algo3.Vista.Handlers.BotonSiguienteSexoEventHandler;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LayoutComputadora extends VBox {

    Jugador jugador;

    public LayoutComputadora(Jugador jugador){

        this.jugador = jugador;

        HBox sexo = crearSexo();
        ListView listView = new ListView();


        Button buscarSospechoso = new Button();
        buscarSospechoso.setAlignment(Pos.BOTTOM_RIGHT);
        buscarSospechoso.setText("Buscar Sospechoso");
        BotonBuscarSospechosoEventHandler botonBuscarSospechosoEventHandler = new BotonBuscarSospechosoEventHandler(jugador, listView, buscarSospechoso);
        buscarSospechoso.setOnAction(botonBuscarSospechosoEventHandler);

        this.getChildren().addAll(sexo, listView, buscarSospechoso);


    }

    private HBox crearSexo(){

        HBox hbox = new HBox();

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        Label sexo = new Label();
        sexo.setText(jugador.getSexoComputadora());

        Button siguienteSexo = new Button();
        siguienteSexo.setText("Siguiente Sexo");
        BotonSiguienteSexoEventHandler botonSiguienteSexoEventHandler = new BotonSiguienteSexoEventHandler(jugador, sexo);
        siguienteSexo.setOnAction(botonSiguienteSexoEventHandler);

        hbox.getChildren().addAll(sexo, siguienteSexo);
        return hbox;
    }



}
