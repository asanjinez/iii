package com.iii.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorDetails detail = new ErrorDetails(new Date(), e.getMessage(), notFound);
        return new ResponseEntity<>(detail,notFound);
    }

    @ExceptionHandler(NombreExistenteException.class)
    public ResponseEntity<?> handleNombreExistenteException(NombreExistenteException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorDetails detail = new ErrorDetails(new Date(), e.getMessage(), badRequest);
        return new ResponseEntity<>(detail,badRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e){
        HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDetails detail = new ErrorDetails(new Date(), e.getMessage(),serverError);
        return new ResponseEntity<>(detail,serverError);

    }
}
