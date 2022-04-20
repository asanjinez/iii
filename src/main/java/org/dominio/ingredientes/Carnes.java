package org.dominio.ingredientes;

public class Carnes extends Ingrediente {

    public Carnes(String nombre, int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente) {
        super(nombre, cantidadCalorias, cantidadIngrediente, unidadIngrediente);
        this.grupo = "Carnes";
    }
}
