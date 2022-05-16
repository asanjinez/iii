package com.iii.exceptions;

public class RecetarioNotFoundException extends RuntimeException{
    public  RecetarioNotFoundException(Long id){
        super("No existe el recetario" + id);
    }
}