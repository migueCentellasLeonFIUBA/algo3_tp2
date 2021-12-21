package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.Vista.LayoutComputadora;
import edu.fiuba.algo3.Vista.LayoutViajar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotonViajarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    BorderPane borderPane;
    Jugador jugador;


    public BotonViajarEventHandler(BorderPane borderPane, Jugador jugador, Stage stage){
        this.borderPane = borderPane;
        this.jugador = jugador;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
        LayoutViajar layoutViajar = crearLayoutViajar();
        //BorderPane newBorderPane = new BorderPane(layoutComputadora, borderPane.getTop(), borderPane.getRight(), borderPane.getBottom(), borderPane.getLeft());
        EscenaPrincipal escenaPrincipal = new EscenaPrincipal(stage, jugador, layoutViajar);
        Scene escenaActulizada = new Scene(escenaPrincipal);
        stage.setScene(escenaActulizada);
    }

    private LayoutViajar crearLayoutViajar(){

        LayoutViajar layoutViajar = new LayoutViajar(jugador, borderPane, stage);

        return layoutViajar;
    }
}
