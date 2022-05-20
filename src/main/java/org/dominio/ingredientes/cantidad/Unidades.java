package org.dominio.ingredientes.cantidad;

public enum Unidades {
    UNIDADES("Unidades"),
    KG("Kg"),
    GR("Gr"),
    LITROS("L"),
    ML("Ml"),
    ND("No determinado");

    private final String unidades;

    private Unidades(String unidades) {
        this.unidades= unidades;
    }

    public String getUnidades() {
        return this.unidades;
    }
}
