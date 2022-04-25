package org.dominio.acciones;

import org.dominio.Receta;
import org.dominio.Recetario;
import org.dominio.perfiles.Perfil;

//Estuve pensando alguna forma de abstraer receta o recetario para que  las acciones sean mejores pero pense que implementar un Object tal vez seria una
//buena opcion
public abstract class Accion  {
    public abstract void accionar(Receta receta, Perfil perfil);
    public abstract  void cambiarEstado(Receta receta, Perfil perfil);

}
