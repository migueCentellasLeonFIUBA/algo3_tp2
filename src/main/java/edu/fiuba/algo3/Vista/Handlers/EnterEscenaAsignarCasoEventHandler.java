package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaAsignarCaso;
import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class EnterEscenaAsignarCasoEventHandler implements EventHandler<KeyEvent> {

    private Integer cantidadEnters;
    private Stage stage;
    private Jugador jugador;
    private VBox leftSide;

    public EnterEscenaAsignarCasoEventHandler(Stage stage, Jugador jugador, VBox leftSide){
        this.cantidadEnters = -1;
        this.jugador = jugador;
        this.stage = stage;
        this.leftSide = leftSide;
    }

    public void handle(KeyEvent keyEvent){

        //String[] descripcion = jugador.getDescripcionCaso().split("\n\n");
        //Text texto = new Text();

        /*EscenaPrincipal principal  = null;
        try {
            principal = new EscenaPrincipal(stage, jugador);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scene escenaPrincipal = new Scene(principal, 960, 600);
        stage.setScene(escenaPrincipal);*/

        if((keyEvent.getCode().equals(KeyCode.ENTER))){
            EscenaPrincipal principal  = null;
            try {
                principal = new EscenaPrincipal(stage, jugador);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Scene escenaPrincipal = new Scene(principal, 960, 600);
            stage.setScene(escenaPrincipal);
        }

        else{
            cantidadEnters++;
        }

        /*if((keyEvent.getCode().equals(KeyCode.ENTER)) && cantidadEnters == 2){

            texto.setText(descripcion[2] + descripcion[3]);
            texto.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
            texto.setTranslateX(15);
            texto.setTranslateY(-450);
            texto.setWrappingWidth(400);

            leftSide.getChildren().add(texto);
            cantidadEnters++;
        }

        if((keyEvent.getCode().equals(KeyCode.ENTER)) && cantidadEnters == 1){

            texto.setText(descripcion[1]);
            texto.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
            texto.setTranslateX(15);
            texto.setTranslateY(-450);
            texto.setWrappingWidth(400);

            leftSide.getChildren().add(texto);
            cantidadEnters++;
        }

        if((keyEvent.getCode().equals(KeyCode.ENTER)) && cantidadEnters == 0){

            texto.setText(descripcion[0]);
            texto.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 18));
            texto.setTranslateX(15);
            texto.setTranslateY(-450);
            texto.setWrappingWidth(400);

            leftSide.getChildren().add(texto);
            cantidadEnters++;

        }*/
    }
}
