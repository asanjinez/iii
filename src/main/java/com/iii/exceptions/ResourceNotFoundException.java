package com.iii.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id) {
        super("No existe el recurso " + id);
    }
}
