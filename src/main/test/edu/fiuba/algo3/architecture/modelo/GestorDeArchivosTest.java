package edu.fiuba.algo3.architecture.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestorDeArchivosTest {

    @Test
    public void elGestorDeArchivosLeeTodosLosSospechosos() throws FileNotFoundException {

        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Sospechosos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();

        leido = gestorArchivos.leerTextoCompleto(ruta);

        assert(leido.contains("Merey Laroc"));
        assert(leido.contains("Carmen"));
    }
}