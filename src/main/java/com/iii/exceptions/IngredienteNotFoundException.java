package com.iii.exceptions;

public class IngredienteNotFoundException extends RuntimeException{
    public IngredienteNotFoundException(Long id) {
        super("No existe el ingrediente " + id);
    }
}
