package org.dominio.ingredientes.cantidad;

//Decido una interfaz en vez de una clase ya que considero que a futuro se podria cambiar las unidades en las que se mide determinado ingrediente
public interface TipoCantidad {
    public String getCantidad();
    public int getCalorias();
}
