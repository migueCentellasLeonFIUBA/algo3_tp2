package CasosDeUso;

import edu.fiuba.algo3.modelo.Ifarcade.Fachada;
import edu.fiuba.algo3.modelo.Ifarcade.GestorDeArchivos;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class pruebaUnitariasLectorYFachada {
    /*
    @Test
    public void unLectorLeePistasYluegoDeFiltrarDanElValorCorrecto() throws IOException {
        GestorDeArchivos lector = new GestorDeArchivos();
        String pistasTexto = lector.leerTextoCompleto("src/main/java/edu/fiuba/algo3/Archivos/Pistas.json");
        Fachada fachada = new Fachada(pistasTexto);
        Long cantidadPistas = fachada.cantidad();
        assertEquals(1, cantidadPistas);
        fachada.filtrar("Facil");
        assertEquals("Dolares.", fachada.pedirValor("Banco"));
        Set<String> set = fachada.setDeElementos();
        fachada.filtrar("Montreal");
        assertEquals("Dolares.", fachada.pedirValor("Banco"));
    }

     */

}
