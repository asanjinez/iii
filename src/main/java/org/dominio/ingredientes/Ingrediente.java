package org.dominio.ingredientes;

public abstract  class Ingrediente {
    private String nombre;
    private int calorias;
    private int cantidad;

    private final String unidad;

    protected String grupo;

    public int getCalorias() {
        return calorias;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getNombre() { return nombre;}

    public Ingrediente(String nombre,int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente){
        this.nombre = nombre;
        this.calorias = cantidadCalorias;   // Hay que pensar como calculo las calorias segun la cantidad?
        this.cantidad = cantidadIngrediente;
        this.unidad = unidadIngrediente;

    }

}

