package org.dominio.ingredientes.cantidad;
public class CantidadNecesaria implements TipoCantidad {
    private final int cantidad = 0;

    private Unidades unidades = Unidades.ND;

    private final int calorias = 0;

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
        return 0;
    }

    @Override
    public String toString() {
        return "Cantidad Necesaria";
    }
}