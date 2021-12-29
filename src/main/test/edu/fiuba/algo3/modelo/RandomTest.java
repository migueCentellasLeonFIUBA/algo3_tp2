package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ManejoArchivos.Randomizador;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
    public void Test01RandomNumeros() {
        Randomizador random = new Randomizador();
        Integer valorRandom = random.obtenerIntegerRandom(3);

    }
}
