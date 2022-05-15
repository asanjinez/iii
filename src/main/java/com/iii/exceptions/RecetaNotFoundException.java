package com.iii.exceptions;

public class RecetaNotFoundException extends RuntimeException{
    public RecetaNotFoundException(Long id){
        super("No existe la receta" + id);
    }
}
