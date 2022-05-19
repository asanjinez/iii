package com.iii.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NombreExistenteAdvice{
    @ResponseBody
    @ExceptionHandler(NombreExistenteException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String ingredienteNotFoundHandler(NombreExistenteException ex) {
        return ex.getMessage();
    }
}





