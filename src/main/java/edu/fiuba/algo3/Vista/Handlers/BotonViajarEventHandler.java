package edu.fiuba.algo3.Vista.Handlers;

//import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.Vista.LayoutViajar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonViajarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    VBox rightSide;
    Jugador jugador;


    public BotonViajarEventHandler(VBox rightSide, Jugador jugador, Stage stage){
        this.rightSide = rightSide;
        this.jugador = jugador;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){


        rightSide.getChildren().remove(2);
        rightSide.getChildren().remove(2);

        crearLayoutViajar();

    }

    private LayoutViajar crearLayoutViajar(){

        LayoutViajar layoutViajar = new LayoutViajar(jugador, rightSide, stage);

        return layoutViajar;
    }
}
