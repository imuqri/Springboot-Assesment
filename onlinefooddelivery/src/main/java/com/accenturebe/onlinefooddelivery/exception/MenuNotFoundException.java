package com.accenturebe.onlinefooddelivery.exception;

public class MenuNotFoundException extends RuntimeException{
    public MenuNotFoundException(String message){
        super(message);
    }
}
