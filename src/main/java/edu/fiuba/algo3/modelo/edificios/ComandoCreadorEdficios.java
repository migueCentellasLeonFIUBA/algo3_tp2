package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.SinPista;

import java.util.Map;

public class ComandoCreadorEdficios {
    private static final Map<String, ICommand> EDIFICIOS;
    static {
        EDIFICIOS = Map.of("Aeropuerto", () -> new AeroPuerto(new SinPista()),
                "Biblioteca", () -> new Biblioteca(new SinPista()),
                "Banco", () -> new Banco(new SinPista()));
    }

    public IEdificio crearEdificio(String playerType) {
        ICommand command = EDIFICIOS.get(playerType);

        if (command == null) {
            throw new IllegalArgumentException("Edificio invalido: " + playerType);
        }

        return command.crear();
    }

}
