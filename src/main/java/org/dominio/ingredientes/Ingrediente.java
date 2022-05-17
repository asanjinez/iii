package org.dominio.ingredientes;

import org.dominio.ingredientes.cantidad.CantidadNecesaria;
import org.dominio.ingredientes.cantidad.TipoCantidad;

public class Ingrediente {
    private final TipoIngrediente grupo;
    private String nombre;
    private String cantidad;
    private int calorias;
    
    private TipoCantidad tipoCantidad;

    public Ingrediente(TipoIngrediente tipo, String nombre, TipoCantidad tipoCantidad){
        this.grupo = tipo;
        this.nombre = nombre;
        this.cantidad = tipoCantidad.getCantidad();
        this.calorias = tipoCantidad.getCalorias();

    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(TipoCantidad cantidad){
        this.cantidad =  cantidad.getCantidad();
        this.calorias = cantidad.getCalorias();
    }

    public int getCalorias() {
        return this.calorias;
    }
    public TipoIngrediente getGrupo() {
        return this.grupo;
    }

    public String getNombre() { return nombre;}
}
