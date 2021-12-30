package edu.fiuba.algo3.Vista.Handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;

public class MouseHoverExitEventHandler implements EventHandler<MouseEvent>{

    Button boton;

    public MouseHoverExitEventHandler(Button boton){

        this.boton = boton;
    }

    public void handle(MouseEvent mouseEvent){

        boton.setEffect(new InnerShadow());
    }
}