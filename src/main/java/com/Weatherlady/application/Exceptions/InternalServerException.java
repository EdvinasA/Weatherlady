package com.Weatherlady.application.Exceptions;
public class InternalServerException extends RuntimeException {

    public InternalServerException(String message) {
        super(message);
    }
}