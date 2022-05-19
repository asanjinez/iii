package com.iii.exceptions;

public class NombreExistenteException extends  RuntimeException{
    public NombreExistenteException(String string){
        super("Ya existe el nombre: " + string);
    }
}
