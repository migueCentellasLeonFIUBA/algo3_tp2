package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IBuilder.ConstructorObjetoConcreto;
import edu.fiuba.algo3.modelo.IBuilder.DirectorObjeto;
import edu.fiuba.algo3.modelo.ManejoArchivos.Fachada;
import edu.fiuba.algo3.modelo.ManejoArchivos.GestorDeArchivos;
import edu.fiuba.algo3.modelo.ManejoArchivos.Objetos;
import edu.fiuba.algo3.modelo.objetos.Objeto;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ObjetoTest {

    @Test
    public void seLeenAlgunosObjetos() throws FileNotFoundException {

        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Objetos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();

        leido = gestorArchivos.leerTextoCompleto(ruta);

        assert(leido.contains("Huevo de 1000 años"));
        assert(leido.contains("Tocado del rey Watusi"));
    }

    @Test
    public void sePuedeCargaUnObjeto() throws FileNotFoundException {

        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Objetos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();

        leido = gestorArchivos.leerTextoCompleto(ruta);

        assert(leido.contains("Huevo de 1000 años"));
        assert(leido.contains("Tocado del rey Watusi"));

        ConstructorObjetoConcreto constructor = new ConstructorObjetoConcreto();
        DirectorObjeto director = new DirectorObjeto();
        director.setConstructorObjeto(constructor);

        Fachada fachada = new Fachada(leido);
        director.construirObjeto(fachada, "Huevo de 1000 años");
        Objeto objeto = director.getObjeto();

        assert(objeto.getRareza() != null ) ;
    }

    @Test
    public void sePuedenCargaAlgunosObjetos() throws FileNotFoundException {

        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Objetos.json";
        String leido;

        gestorArchivos = new GestorDeArchivos();

        leido = gestorArchivos.leerTextoCompleto(ruta);

        assert(leido.contains("Huevo de 1000 años"));
        assert(leido.contains("Tocado del rey Watusi"));

        ConstructorObjetoConcreto constructor = new ConstructorObjetoConcreto();
        DirectorObjeto director = new DirectorObjeto();
        director.setConstructorObjeto(constructor);

        Fachada fachada = new Fachada(leido);
        director.construirObjeto(fachada, "Huevo de 1000 años");
        Objeto objeto = director.getObjeto();

        assert(objeto.getRareza() != null ) ;

        director.construirObjeto(fachada, "Tocado del rey Watusi");
        objeto = director.getObjeto();

        assert(objeto.getRareza() != null ) ;
    }

    @Test
    public void TestObjetoRandomFiltradoPorValor() throws FileNotFoundException {
        GestorDeArchivos gestorArchivos;
        String ruta = "src/main/java/edu/fiuba/algo3/Archivos/Objetos.json";
        gestorArchivos = new GestorDeArchivos();


        Objetos objetos = new Objetos(gestorArchivos.leerTextoCompleto(ruta));
        Objeto objeto = objetos.ObtenerObjetoRandom("Comun");
        //EL OBJETO ES COMUN


    }
}
