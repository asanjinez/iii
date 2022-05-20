package org.dominio.ingredientes;

public enum TipoIngrediente {
    CARNES("Carnes"),
    CEREALES("Cereales"),
    FRUTAS("Frutas"),
    LACTEOS("Lacteos"),
    LEGUMBRES("Legumbres"),
    VEGETALES("Vegetales");

    private final String tipo;
    private TipoIngrediente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
