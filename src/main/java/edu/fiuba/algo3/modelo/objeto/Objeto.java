package edu.fiuba.algo3.modelo.objeto;

public class Objeto{

    private String nombre;
    private String ciudad;
    private Rareza rareza;

    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public void setCiudad(String origen){
        this.ciudad = origen;
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
}
