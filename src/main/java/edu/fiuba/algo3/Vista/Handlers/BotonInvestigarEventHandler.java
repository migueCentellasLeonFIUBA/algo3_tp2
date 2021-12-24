package edu.fiuba.algo3.Vista.Handlers;

//import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.Vista.LayoutInvestigar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BotonInvestigarEventHandler implements EventHandler<ActionEvent> {

    HBox hbox;
    Jugador jugador;
    Stage stage;
    public BotonInvestigarEventHandler(HBox hbox, Jugador jugador, Stage stage){
        this.hbox = hbox;
        this.jugador = jugador;
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent){
/*
        LayoutInvestigar layoutInvestigar = crearLayoutInvestigar();
        EscenaPrincipal escenaPrincipal = new EscenaPrincipal(stage, jugador, layoutInvestigar);
        Scene escenaActulizada = new Scene(escenaPrincipal);
        stage.setScene(escenaActulizada);
        stage.setFullScreen(true);*/
    }

    private LayoutInvestigar crearLayoutInvestigar(){

        LayoutInvestigar layoutInvestigar = new LayoutInvestigar(jugador);

        return layoutInvestigar;
    }
}
