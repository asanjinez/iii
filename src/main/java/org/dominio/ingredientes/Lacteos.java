package org.dominio.ingredientes;

//lácteos, carnes, legumbres, vegetales, frutas, cereales.
public class Lacteos extends Ingrediente {

    public Lacteos(String nombre, int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente) {
        super(nombre, cantidadCalorias, cantidadIngrediente, unidadIngrediente);
        this.grupo = "Lacteos";

    }
}
