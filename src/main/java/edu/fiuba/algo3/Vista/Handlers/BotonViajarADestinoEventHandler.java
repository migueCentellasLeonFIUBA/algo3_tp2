package edu.fiuba.algo3.Vista.Handlers;

import edu.fiuba.algo3.Vista.EscenaPrincipal;
import edu.fiuba.algo3.Vista.LayoutComputadora;
import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotonViajarADestinoEventHandler implements EventHandler<ActionEvent> {

    Jugador jugador;
    BorderPane borderPane;
    Stage stage;
    Ciudad destino;

    public BotonViajarADestinoEventHandler(Jugador jugador, BorderPane borderPane, Stage stage, Ciudad destino){
        this.jugador = jugador;
        this.borderPane = borderPane;
        this.stage = stage;
        this.destino = destino;
    }

    public void handle(ActionEvent actionEvent){
        jugador.viajarACiudad(destino);
        TextArea center = crearCenter();
        //BorderPane newBorderPane = new BorderPane(layoutComputadora, borderPane.getTop(), borderPane.getRight(), borderPane.getBottom(), borderPane.getLeft());
        EscenaPrincipal escenaPrincipal = new EscenaPrincipal(stage, jugador, center);
        Scene escenaActulizada = new Scene(escenaPrincipal);
        stage.setScene(escenaActulizada);


    }

    private TextArea crearCenter(){

        TextArea textArea = new TextArea();
        //textArea.setMaxSize(600, 600);

        String descripcion;
        descripcion = jugador.getDescripcionCiudad();

        textArea.setText(descripcion);
        return textArea;
    }
}
