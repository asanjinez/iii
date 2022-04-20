package org.dominio.ingredientes;

public class Legumbres extends Ingrediente {

    public Legumbres(String nombre, int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente) {
        super(nombre, cantidadCalorias, cantidadIngrediente, unidadIngrediente);
        this.grupo = "Legumbres";
    }
}
