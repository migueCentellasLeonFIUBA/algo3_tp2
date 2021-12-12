package edu.fiuba.algo3.IBuilder;

import edu.fiuba.algo3.modelo.objetos.Objeto;

public interface ConstructorObjeto {

    void setNombre(String nombre);
    void setOrigen(String origen);
    void setValor(String clase);
    Objeto getObjeto();
}
