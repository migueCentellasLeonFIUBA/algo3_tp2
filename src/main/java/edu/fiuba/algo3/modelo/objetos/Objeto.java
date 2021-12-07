package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.objetos.Valor;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Objeto{

    private String nombre;
    private String ciudad;
    private Rareza rareza;
    private Valor valor;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCiudad(String origen){
        this.ciudad = origen;
    }

    public void setRareza(Rareza clase){
        this.rareza = clase;
    }

    public void setClase(String clase){
        if ( clase.equals("Comun"))
            this.rareza = new RarezaComun();
        else if (clase.equals("Valioso"))
            this.rareza = new RarezaValioso();
        else
            this.rareza = new RarezaMuyValioso();
    }

    public String getNombre(){
        return nombre;
    }

    //borrar
    public Rareza getRareza(){
        return this.rareza;
    }

    public Estrategia crearEstrategia(Ciudad ciudad){
        return(valor.crearEstrategia(ciudad));
    }
}
