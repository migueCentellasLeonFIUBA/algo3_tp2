package edu.fiuba.algo3.Vista.Handlers;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LayoutGeneral extends HBox {


    public LayoutGeneral(){
    }

    public VBox crearLeftSide() {

        VBox leftSide = new VBox();
        leftSide.setSpacing(10);
        leftSide.setMaxWidth(420);
        leftSide.setMaxHeight(600);

        Rectangle hora = new Rectangle();
        hora.setHeight(80);
        hora.setWidth(415);
        hora.setStroke(Color.DARKGRAY);
        hora.setFill(Color.DARKGRAY);
        hora.toBack();
        hora.setStroke(Color.DARKGRAY);
        hora.setStrokeWidth(15);
        hora.setStrokeType(StrokeType.CENTERED);
        hora.setArcHeight(25);
        hora.setArcWidth(25);


        Rectangle computadora = new Rectangle();
        computadora.setHeight(385);
        computadora.setWidth(415);
        computadora.setStroke(Color.DARKGRAY);
        computadora.setFill(Color.DARKGRAY);
        computadora.toBack();
        computadora.setStroke(Color.DARKGRAY);
        computadora.setStrokeWidth(15);
        computadora.setStrokeType(StrokeType.CENTERED);
        computadora.setArcHeight(25);
        computadora.setArcWidth(25);


        leftSide.getChildren().addAll(hora, computadora);
        return leftSide;
    }

    public VBox crearRightSide() {
        VBox leftSide = new VBox();
        leftSide.setSpacing(10);
        leftSide.setMaxWidth(420);
        leftSide.setMaxHeight(600);

        Rectangle pantalla = new Rectangle();
        pantalla.setHeight(385);
        pantalla.setWidth(415);
        pantalla.setStroke(Color.DARKGRAY);
        pantalla.setFill(Color.DARKGRAY);
        pantalla.toBack();
        pantalla.setStroke(Color.DARKGRAY);
        pantalla.setStrokeWidth(15);
        pantalla.setStrokeType(StrokeType.CENTERED);
        pantalla.setArcHeight(25);
        pantalla.setArcWidth(25);

        Rectangle botones = new Rectangle();
        botones.setHeight(80);
        botones.setWidth(415);
        botones.setStroke(Color.DARKGRAY);
        botones.setFill(Color.DARKGRAY);
        botones.toBack();
        botones.setStroke(Color.DARKGRAY);
        botones.setStrokeWidth(15);
        botones.setStrokeType(StrokeType.CENTERED);
        botones.setArcHeight(25);
        botones.setArcWidth(25);

        leftSide.getChildren().addAll(pantalla, botones);
        return leftSide;
    }
}
