package org.dominio;

public interface Observer {
    public default void actualizar(Receta receta){

    }
    public default void actualizar(){
    }
}
