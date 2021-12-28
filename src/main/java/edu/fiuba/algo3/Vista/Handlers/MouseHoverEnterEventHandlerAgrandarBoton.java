package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class MouseHoverEnterEventHandlerAgrandarBoton implements EventHandler<MouseEvent> {

    Button boton;
    public MouseHoverEnterEventHandlerAgrandarBoton(Button boton){
        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setEffect(new DropShadow());
    }
}

