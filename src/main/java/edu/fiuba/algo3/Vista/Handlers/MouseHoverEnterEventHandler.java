package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class MouseHoverEnterEventHandler implements EventHandler<MouseEvent> {

    Button boton;

    public MouseHoverEnterEventHandler(Button boton){

        this.boton = boton;
    }

    public void handle(MouseEvent mouseEvent){

        boton.setEffect(new DropShadow());

    }
}
