package edu.fiuba.algo3.modelo.edificios;
import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.ManejoArchivos.Pistas;
import edu.fiuba.algo3.modelo.rangos.GradoPolicia;
import java.io.FileNotFoundException;

public class Banco implements Edificio {
    private String nombre;


    public Banco(){
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
    public String aceptar(Visitante unVisitante) {
        return unVisitante.visitar(this);
    }
}
