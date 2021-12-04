package edu.fiuba.algo3.modelo.ciudad;



public class Coordenadas {

    private float latitud;
    private float longitud;

    //Operations
    public int CalcularDistancia(Coordenadas destino) {
        //TODO
        return 0;
    }

    public void setLatitud(float latitud){ this.latitud = latitud;}

    public void setLongitud(float longitud){ this.longitud = longitud;}

    private float obtenerLatitud() {
        return latitud;
    }

    private float obtenerLongitud() {
        return longitud;
    }
    
}
