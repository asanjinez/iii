package org.dominio.ingredientes;

public class Frutas extends Ingrediente {

    public Frutas(String nombre, int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente) {
        super(nombre, cantidadCalorias, cantidadIngrediente, unidadIngrediente);
        this.grupo = "Frutas";
    }
}
