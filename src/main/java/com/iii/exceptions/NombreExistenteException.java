package com.iii.exceptions;

public class NombreExistenteException extends RuntimeException{
    public NombreExistenteException(String nombre){
        super("Ya existe el nombre " + nombre);
    }
}
