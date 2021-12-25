package edu.fiuba.algo3.modelo.edificios;

import java.util.Map;

public class ComandoCreadorEdficios {
    private static final Map<String, ICommand> EDIFICIOS;

    static {

        EDIFICIOS = Map.of("Aeropuerto", new ICommand() {
            @Override
            public IEdificio crear() {
                return new AeroPuerto();
            }
        }, "Biblioteca", new ICommand() {
            @Override
            public IEdificio crear() {
                return new Biblioteca();
            }
        }, "Banco", new ICommand() {
            @Override
            public IEdificio crear() {
                return new Banco();
            }
        });
    }

    public IEdificio crearEdificio(String playerType) {
        ICommand command = EDIFICIOS.get(playerType);

        if (command == null) {
            throw new IllegalArgumentException("Edificio invalido: " + playerType);
        }

        return command.crear();
    }

}
