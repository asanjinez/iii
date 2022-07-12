package com.iii.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {
    private final Date timestamp;
    private final String message;
    private final HttpStatus status;

    public ErrorDetails(Date timestamp, String message, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
