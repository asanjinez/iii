package org.dominio.ingredientes.cantidad;

public class CantidadNecesaria implements TipoCantidad {

    @Override
    public String getCantidad() {
        return "C/N";
    }

    @Override
    public int getCalorias() {
        return 0;
    }
}
