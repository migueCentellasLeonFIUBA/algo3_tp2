package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.Ifarcade.Pistas;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import java.io.FileNotFoundException;

public class Banco implements Edificio {
    private String nombre;


    private Banco(){
        nombre="Banco";
    }

    public static Banco crearBanco() {
        return new Banco();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String visitarEdificio(Pistas pistas) throws FileNotFoundException {

        return pistas.ObtenerPista(this);
    }

    @Override
    public String visitarEdificio(String proximaCiudad, GradoPolicia grado) {
        return null;
    }
}
