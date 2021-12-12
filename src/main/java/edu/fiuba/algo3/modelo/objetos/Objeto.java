package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ladron.Estrategia;
import edu.fiuba.algo3.modelo.objetos.Valor;
import edu.fiuba.algo3.modelo.ladron.Estrategia;

public class Objeto{

    private String nombre;
    private String origen;
    private Valor valor;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setOrigen(String origen){
        this.origen = origen;
    }

    public void setValor(String clase){
        if ( clase.equals("Comun"))
            this.valor = new Comun();
        else if (clase.equals("Valioso"))
            this.valor = new Valioso();
        else
            this.valor = new MuyValioso();
    }

    public Valor getRareza(){
        return this.valor;
    }

    public Estrategia crearEstrategia(Ciudad ciudad){
        return(valor.crearEstrategia(ciudad));
    }
}
