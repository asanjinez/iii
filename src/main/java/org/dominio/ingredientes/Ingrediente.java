package org.dominio.ingredientes;

public class Ingrediente {
    private final TipoIngrediente grupo;
    private String nombre;
    private int calorias;
    private int cantidad;

    private final String unidad;


    public int getCalorias() {
        return calorias;
    }

    public String getGrupo() {
        return this.grupo.getTipo();
    }

    public String getNombre() { return nombre;}

    public Ingrediente(TipoIngrediente tipo, String nombre,int cantidadCalorias, int cantidadIngrediente, String unidadIngrediente){
        this.grupo = tipo;
        this.nombre = nombre;
        this.calorias = cantidadCalorias;   // Hay que pensar como calculo las calorias segun la cantidad?
        this.cantidad = cantidadIngrediente;
        this.unidad = unidadIngrediente;

    }

}

