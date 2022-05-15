package com.iii.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class RecetaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RecetaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String recetaNotFoundHandler(RecetaNotFoundException ex) {
        return ex.getMessage();
    }
}
