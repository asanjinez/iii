package org.dominio.ingredientes;

import org.dominio.ingredientes.cantidad.CantidadNecesaria;
import org.dominio.ingredientes.cantidad.TipoCantidad;
import org.dominio.ingredientes.cantidad.Unidades;

public class Ingrediente {
    private final TipoIngrediente grupo;
    private String nombre;
    private TipoCantidad tipoCantidad;

    public Ingrediente(TipoIngrediente tipo, String nombre, TipoCantidad tipoCantidad){
        this.grupo = tipo;
        this.nombre = nombre;
        this.tipoCantidad = tipoCantidad;

    }

    public int getCantidad() {
        return tipoCantidad.getCantidad();
    }

    public void setCantidad(TipoCantidad cantidad){
        this.tipoCantidad = cantidad;
    }

    public int getCalorias() {
        return this.tipoCantidad.getCalorias();
    }
    public TipoIngrediente getGrupo() {
        return this.grupo;
    }

    public String getNombre() { return nombre;}

}
