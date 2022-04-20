package org.dominio.ingredientes;

public class Cereales extends Ingrediente {

    public Cereales(String nombre, int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente) {
        super(nombre, cantidadCalorias, cantidadIngrediente, unidadIngrediente);
        this.grupo = "Cereales";
    }
}
