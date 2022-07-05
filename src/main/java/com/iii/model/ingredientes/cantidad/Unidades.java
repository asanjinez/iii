package com.iii.model.ingredientes.cantidad;

public enum Unidades {
    UNIDADES("Unidades"),
    KG("Kg"),
    GR("Gr"),
    LITROS("L"),
    ML("Ml"),
    CN("Cantidad necesaria");

    private final String unidades;

    private Unidades(String unidades) {
        this.unidades = unidades;
    }

    public String getUnidades() {
        return this.unidades;
    }
}