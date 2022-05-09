package com.iii.model.perfiles;

/*
	Celiaco		No contener cereales
	Vegetariano		No contener carnes
	Vegano		No contener carnes o lácteos
	Carnívoro		Contener carnes y alcanzar las 200 calorías

 */


import com.iii.model.Receta;
import com.iii.model.acciones.Accion;

public interface Perfil {
    public boolean puedeComer(Receta receta);
    public default void notificar(){
//        System.out.println("Perfil " + "notificado");
    }
    String getNombre();

    Accion getEstadoNotificar();

    void setEstadoNotificar(Accion accion);
}

