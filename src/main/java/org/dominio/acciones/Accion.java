package org.dominio.acciones;

//Estuve pensando alguna forma de abstraer receta o recetario para que  las acciones sean mejores pero pense que implementar un Object tal vez seria una
//buena opcion
public abstract class Accion {
    boolean estado = true;
    public void accionar() {}
    public void cambiarEstado() {
        this.estado = !estado;
    };

}