package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Parser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void Test01ParseaUnTextoYConsigueSusValores(){
        Parser parser = new Parser();
        parser.parsear("src/main/java/edu/fiuba/algo3/Archivos/Ciudades.json");
        parser.filtrar("Montreal");
        List<String> listaDeEdificios = parser.pedirArreglo("Edificios");
        Assert.assertEquals(listaDeEdificios.size(),3);
        Assert.assertEquals(parser.pedirValor("descripcion"),"Ciudad de montreal");

    }
}
