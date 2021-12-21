package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.Vista.LayoutComputadora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonComputadoraEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    BorderPane borderPane;
    Jugador jugador;

    public BotonComputadoraEventHandler(BorderPane borderPane, Jugador jugador, Stage stage){
        this.borderPane = borderPane;
        this.jugador = jugador;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
        LayoutComputadora layoutComputadora = crearLayoutComputadora();
        //BorderPane newBorderPane = new BorderPane(layoutComputadora, borderPane.getTop(), borderPane.getRight(), borderPane.getBottom(), borderPane.getLeft());
        EscenaPrincipal escenaPrincipal = new EscenaPrincipal(stage, jugador, layoutComputadora);
        Scene escenaActulizada = new Scene(escenaPrincipal);
        stage.setScene(escenaActulizada);
        stage.setFullScreen(true);
    }

    private LayoutComputadora crearLayoutComputadora(){

        LayoutComputadora layoutComputadora = new LayoutComputadora(jugador);

        return layoutComputadora;
    }
}
