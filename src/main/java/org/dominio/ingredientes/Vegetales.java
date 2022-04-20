package org.dominio.ingredientes;

public class Vegetales extends Ingrediente {

    public Vegetales(String nombre, int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente) {
        super(nombre, cantidadCalorias, cantidadIngrediente, unidadIngrediente);
        this.grupo = "Vegetales";
    }
}
