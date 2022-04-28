package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionNotificarHabilitada;
/*
	Celiaco		No contener cereales
	Vegetariano		No contener carnes
	Vegano		No contener carnes o lácteos
	Carnívoro		Contener carnes y alcanzar las 200 calorías

 */


public interface Perfil {
    public boolean puedeComer(Receta receta);
    public default void notificar(){
//        System.out.println("Perfil " + "notificado");
    }
    String getNombre();

    Accion getEstadoNotificar();

    void setEstadoNotificar(Accion accion);
}

