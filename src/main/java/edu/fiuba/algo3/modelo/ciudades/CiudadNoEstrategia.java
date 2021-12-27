package edu.fiuba.algo3.modelo.ciudades;


import edu.fiuba.algo3.modelo.IVisitor.Visitante;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.jugador.Reloj;
import edu.fiuba.algo3.modelo.ladron.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiudadNoEstrategia extends Ciudad{
    public CiudadNoEstrategia(String nombreCiudad,String descripcion,Coordenadas coordenadas,ArrayList<IEdificio> edificios) {
        super(nombreCiudad,descripcion,coordenadas,edificios);
    }



}
