package com.iii.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class IngredienteNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(IngredienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(IngredienteNotFoundException ex) {
        return ex.getMessage();
    }
}
