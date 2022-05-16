package com.iii.model.acciones;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.iii.model.Receta;
import com.iii.model.perfiles.Perfil;

//Estuve pensando alguna forma de abstraer receta o recetario para que  las acciones sean mejores pero pense que implementar un Object tal vez seria una
//buena opcion
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public interface Accion  {
    public abstract void accionar(Receta receta, Perfil perfil);
    public abstract  void cambiarEstado(Receta receta, Perfil perfil);

}
