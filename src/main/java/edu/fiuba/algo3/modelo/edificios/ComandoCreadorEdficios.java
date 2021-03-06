package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Pistas.IPista;

import java.util.Map;

public class ComandoCreadorEdficios {
    private static final Map<String, ICommand> EDIFICIOS;

    static {

        EDIFICIOS = Map.of("Aeropuerto", new ICommand() {
            @Override
            public Edificio crear(IPista pista) {
                return new AeroPuerto(pista);
            }
        }, "Biblioteca", new ICommand() {
            @Override
            public Edificio crear(IPista pista) {
                return new Biblioteca(pista);
            }
        }, "Banco", new ICommand() {
            @Override
            public Edificio crear(IPista pista) {
                return new Banco(pista);
            }
        });
    }

    public Edificio crearEdificio(String playerType, IPista pista) {
        ICommand command = EDIFICIOS.get(playerType);

        if (command == null) {
            throw new IllegalArgumentException("Edificio invalido: " + playerType);
        }

        return command.crear(pista);
    }

}
