package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MouseHoverExitEventHandlerAchicarBoton implements EventHandler<MouseEvent> {

    Button boton;

    public MouseHoverExitEventHandlerAchicarBoton(Button boton){

        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setEffect(null);
    }
}
