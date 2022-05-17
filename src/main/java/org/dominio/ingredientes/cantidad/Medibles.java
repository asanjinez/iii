package org.dominio.ingredientes.cantidad;

public class Medibles implements TipoCantidad {
    int cantidad = 0;
    String unidades;
    int calorias;

    public Medibles(int cantidad, String unidades, int calorias) {
        this.cantidad = cantidad;
        this.unidades = unidades;
        this.calorias = calorias;
    }

    @Override
    public String getCantidad() {
        return Integer.toString(cantidad) + unidades;
    }

    @Override
    public int getCalorias(){
        return calorias;
    };
}
