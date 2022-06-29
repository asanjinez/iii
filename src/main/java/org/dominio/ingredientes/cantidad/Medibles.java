package org.dominio.ingredientes.cantidad;
public class Medibles implements TipoCantidad {
    private int cantidad;
    private Unidades unidades;
    private int calorias;

    public Medibles(int cantidad, Unidades unidades, int calorias) {
        this.cantidad = cantidad;
        this.unidades = unidades;
        this.calorias = calorias;
    }

    @Override
    public int getCantidad() {
        return this.cantidad;
    }

    @Override
    public String getUnidades() {
        return this.unidades.getUnidades();
    }

    @Override
    public int getCalorias() {
        return this.calorias;
    }
    @Override
    public String toString() {
        return Integer.toString(this.cantidad) + this.getUnidades();
    }
}