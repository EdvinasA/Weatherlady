package com.Weatherlady.application.Exceptions;

public class BadGatawayException extends RuntimeException {

    public BadGatawayException(String message){
        super(message);
    }
}